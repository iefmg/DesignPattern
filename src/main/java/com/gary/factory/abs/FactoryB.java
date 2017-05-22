package com.gary.factory.abs;

/**
 * @author gefengming
 * @date 17/5/21
 */
public class FactoryB implements Factory {

    @Override
    public Product1 createProduct1() {
        return new Product1_B();
    }

    @Override
    public Product2 createProduct2() {
        return new Product2_B();
    }
}
