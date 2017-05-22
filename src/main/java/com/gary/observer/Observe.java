package com.gary.observer;

/**
 * @author gefengming
 *
 * 观察者接口
 *
 * @date 17/5/21
 */
public interface Observe {

    void update(Observable observable, Object[] args);

}
