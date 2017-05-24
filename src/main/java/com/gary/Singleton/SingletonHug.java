package com.gary.singleton;

/**
 * @author gefengming
 *
 * 饿汉模式,
 *
 * @date 17/5/20
 */
public class SingletonHug extends AbsSingleton{

    /**
     * 静态域第一次访问时,完成实例化
     */
    private static SingletonHug singletonHug = new SingletonHug();

    private SingletonHug(){
    }

    public static SingletonHug getInstance(){
        return singletonHug;
    }
}
