package com.gary.observer;

import java.util.Vector;

/**
 * @author gefengming
 *
 * 被观察者
 *
 * @date 17/5/21
 */
public class Observable {

    private boolean changed = false;

    Vector<Observe> observeVector = new Vector<>();

    /**
     * 添加观察者
     * @param observe
     */
    public synchronized void addObserve(Observe observe){
        if(null == observe){
            throw new NullPointerException();
        }
        if(!observeVector.contains(observe)){
            observeVector.add(observe);
        }
    }

    /**
     * 删除观察者
     * @param observe
     */
    public synchronized void deleteObserve(Observe observe){
        observeVector.remove(observe);
    }

    public void change(){
        System.out.println("被观察者 do something ..");
        changed = true;
        notifyAllObserve(null);
    }


    /**
     * 通知观察者响应
     */
    public void notifyAllObserve(Object[] args){

        //临时存放观察者列表
        Object[] arrLocal;

        //支持多线程动态修改通知列表
        synchronized (this){
            if(!changed){
                return;
            }
            System.out.println("我是被观察者, 变化了, 准备通知观察者");
            arrLocal = observeVector.toArray();
            changed = false;
        }

        //通知每一个观察者
        for(int i=0; i<arrLocal.length; i++){
            ((Observe)arrLocal[i]).update(this, args);
        }
    }
}
