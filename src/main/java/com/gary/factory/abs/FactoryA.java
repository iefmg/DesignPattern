package com.gary.factory.abs;

/**
 * @author gefengming
 * @date 17/5/21
 */
public class FactoryA implements Factory {

    @Override
    public Product1 createProduct1() {
        return new Product1_A();
    }

    @Override
    public Product2 createProduct2() {
        return new Product2_A();
    }
}
