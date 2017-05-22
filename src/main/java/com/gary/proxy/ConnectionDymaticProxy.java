package com.gary.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * @author gefengming
 *
 * 动态代理模式,运行时创建class
 *
 * @date 17/5/20
 */
public class ConnectionDymaticProxy implements InvocationHandler {

    private Connection connection;

    public ConnectionDymaticProxy(Connection connection) {
        this.connection = connection;
    }

    /**
     * invoke具体处理代理类的每一个方法执行
     * @param proxy  com.sun.proxy.$Proxy0
     * @param method java.lang.reflect.Method
     * @param args 方法参数列表
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println(connection.getClass() +" == "+proxy.getClass() +" -> "+ connection.getClass().isAssignableFrom(proxy.getClass()));
        //动态代理Connection.close()方法
        if(method.getName().equals("close")){
            //我们不执行真正的close方法
            //method.invoke(connection, args);
            System.out.println(Thread.currentThread().getName()+ " 不真正关闭连接，归还给连接池");
            //将连接归还连接池
            DataSourcePool.getInstance().recoveryConnection(connection);
            return null;
        }
        else{
            //正常执行原有方法
            return method.invoke(connection, args);
        }
    }

    /**
     * Proxy产生被代理类Connection
     * 被代理类必须实现某一接口
     *
     * 参数:
     * 当前ClassLoader: sun.misc.Launcher$AppClassLoader
     * 需要被代理类的接口列表: Connection.class
     * InvocationHandler
     * @return
     */
    public Connection getConnectionProxy(){
        return (Connection) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{Connection.class}, this);
    }
}
