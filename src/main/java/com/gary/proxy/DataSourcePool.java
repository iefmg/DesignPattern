package com.gary.proxy;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.LinkedList;


/**
 * @author gefengming
 *
 * 数据库连接池
 * @date 17/5/20
 */
public class DataSourcePool {

    /**
     * 连接池
     */
    private static LinkedList<Connection> connectionLinkedList = new LinkedList<Connection>();

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection createNewConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_name","username", "password");
    }

    /**
     * 连接池初始化
     */
    private DataSourcePool(){
        if (connectionLinkedList.size() == 0){
            for(int i=0; i<10; i++){
                try{
                    connectionLinkedList.add(createNewConnection());
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 获取连接
     * @return
     */
    public Connection getConnection() throws InterruptedException{
        while (true){
            if (connectionLinkedList.size() > 0){
                synchronized (DataSourcePool.class){
                    if(connectionLinkedList.size() > 0){
//                        //静态代理的方式，调用close时，可以自动归还到连接池
//                        return new ConnectionStaticProxy(connectionLinkedList.remove());
                        //动态代理方式, 调用close时, 可以自动归还到连接池
                        return new ConnectionDymaticProxy(connectionLinkedList.remove()).getConnectionProxy();

                    }
                }

            }
            Thread.sleep(1000);
        }
    }

    /**
     * 释放连接
     * @param connection
     */
    public void recoveryConnection(Connection connection){
        connectionLinkedList.add(connection);
        System.out.println(Thread.currentThread().getName()+ "释放后, 可用连接数:" +DataSourcePool.getInstance().availbleConnect());
    }

    /**
     * 当前可用连接数
     * @return
     */
    public int availbleConnect(){
        return connectionLinkedList.size();
    }

    //单例模式 获取连接池实例
    public static DataSourcePool getInstance(){
        return DataSourcePoolSingle.instance;
    }

    private static class DataSourcePoolSingle{
        private static DataSourcePool instance = new DataSourcePool();
    }
}
