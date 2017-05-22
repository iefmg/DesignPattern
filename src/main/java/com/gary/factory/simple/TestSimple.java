package com.gary.factory.simple;

/**
 * @author gefengming
 * @date 17/5/21
 */
public class TestSimple {

    public static void main(String []args){
        IProduct a = Creator.createProduct("a");
        a.method();
        IProduct b = Creator.createProduct("b");
        b.method();
    }
}
