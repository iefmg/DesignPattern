package com.gary.observer;

/**
 * @author gefengming
 *
 * 观察者B
 *
 * @date 17/5/21
 */
public class ConcreteObserveB implements Observe {

    @Override
    public void update(Observable observable, Object[] args) {
        System.out.println(getClass().getName() + "B收到" + observable.getClass().getName() + "变化的消息");
    }
}
