package com.gary.factory.method;

/**
 * @author gefengming
 * @date 17/5/21
 */
public class BulbCreator implements Creator {

    @Override
    public Light createLight() {
        return new BulbLight();
    }
}
