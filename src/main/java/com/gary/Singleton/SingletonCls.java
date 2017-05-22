package com.gary.Singleton;

/**
 * @author gefengming
 *
 * 静态内部类模式
 *
 * 类的静态属性只会在第一次加载时完成初始化,JVM保证
 *
 * @date 17/5/20
 */
public class SingletonCls extends AbsSingleton{

    private SingletonCls(){}

    public static SingletonCls getInstance(){
        return SingletonInstance.instance;
    }

    private static class SingletonInstance {
        static SingletonCls instance = new SingletonCls();
    }

}
