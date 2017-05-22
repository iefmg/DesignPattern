package com.gary.proxy;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.sql.Connection;

/**
 * @author gefengming
 *
 * @date 17/5/20
 */
public class TestProxy {

    public static void main(String args[]){
        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i=0; i<10; i++){
            executor.execute(new Runnable() {
                public void run() {
                    try{
                        Connection connection = DataSourcePool.getInstance().getConnection();
                        //do something
                        System.out.println(Thread.currentThread().getName() +" "+ connection);
                        Thread.sleep(1000);
                        connection.close();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }catch (SQLException e1){
                        e1.printStackTrace();
                    }
                }
            });
        }

        executor.shutdown();


    }
}
