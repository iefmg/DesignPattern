package com.gary.factory.simple;

/**
 * @author gefengming
 *
 * @date 17/5/21
 */
public class Creator {

    private Creator(){}

    public static IProduct createProduct(String name){
        if (name.equalsIgnoreCase("a")){
            return new ProductA();
        }
        if (name.equalsIgnoreCase("b")){
            return new ProductB();
        }
        return null;
    }
}
