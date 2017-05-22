package com.gary.factory.method;

/**
 * @author gefengming
 * @date 17/5/21
 */
public class TubeCreator implements Creator {

    @Override
    public Light createLight() {
        return new TubeLight();
    }
}
