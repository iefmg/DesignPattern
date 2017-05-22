package com.gary.factory.simple;

/**
 * @author gefengming
 * @date 17/5/21
 */
public class ProductB implements IProduct {

    @Override
    public void method() {
        System.out.println(getClass().getName() + " ProductB响应!");
    }
}
