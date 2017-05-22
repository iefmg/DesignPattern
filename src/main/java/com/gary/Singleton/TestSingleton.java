package com.gary.Singleton;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gefengming
 *
 * @date 17/5/20
 */
public class TestSingleton {

    public static <T extends AbsSingleton> void multiThreadCheck(final Class<T> Singleton) throws InterruptedException{

        //线程记录
        final Set<String> set = Collections.synchronizedSet(new HashSet<String>());

        //同步计数器
        final CountDownLatch cdl = new CountDownLatch(1);

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    try {
                        //计数器>1 时堵塞当前线程
                        cdl.await();
                        //反射拿到方法
                        Method getInstance = Singleton.getDeclaredMethod("getInstance", null);
                        //执行静态方法
                        AbsSingleton absSingleton = (AbsSingleton) getInstance.invoke(null, null);
                        set.add(absSingleton.toString());

                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    catch (Exception e1){
                        e1.printStackTrace();
                    }
                }
            });
        }
        Thread.sleep(1000);
        //计数器-1
        cdl.countDown();
        Thread.sleep(1000);
        System.out.println(Singleton.getName() + "一共有" + set.size() + "个实例");
        for (String str : set) {
            System.out.println(str);
        }

        executor.shutdown();

    }

    public static void main(String []args) throws InterruptedException {
        multiThreadCheck(SingletonSyn.class);
        multiThreadCheck(SingletonCls.class);
        multiThreadCheck(SingletonHug.class);
    }
}
