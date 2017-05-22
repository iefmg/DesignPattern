package com.gary.observer;

/**
 * @author gefengming
 *
 * @date 17/5/21
 */
public class Client {
    public static void main(String []args){
        Observable observable = new Observable();
        observable.addObserve(new ConcreteObserveA());
        observable.addObserve(new ConcreteObserveB());

        observable.change();
    }
}
