package com.gary.factory.method;

/**
 * @author gefengming
 * @date 17/5/21
 */
public class Client {

    public static void main(String []args){
        Creator creator = new BulbCreator();
        Light light = creator.createLight();
        light.turnon();
        light.turnoff();

        creator = new TubeCreator();
        light = creator.createLight();
        light.turnon();
        light.turnoff();

    }
}
