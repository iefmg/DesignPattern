package com.gary.Singleton;

/**
 * @author gefengming
 *
 * 双重加锁模式(volatile版)
 *
 * @date 17/5/20
 */
public class SingletonSyn extends AbsSingleton{

    /**
     * volatile 禁止JVM指令重排序, 构造过程2和3保持不变
     */
    private volatile static SingletonSyn singletonSyn;

    private SingletonSyn(){
    }

    public static SingletonSyn getInstance(){
        /**
         * 竞争锁的线程
         */
        if (null == singletonSyn){
            synchronized (SingletonSyn.class){
                /**
                 * 拿到锁的线程判断是否需要实例化
                 */
                if (null == singletonSyn){
                    /**
                     * 构造过程
                     * 1 分配内存空间
                     * 2 初始化构造器
                     * 3 对象指向分配的内存地址
                     */
                    singletonSyn = new SingletonSyn();
                }
            }
        }
        return singletonSyn;
    }

}
