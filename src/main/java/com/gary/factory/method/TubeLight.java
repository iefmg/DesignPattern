package com.gary.factory.method;

/**
 * @author gefengming
 *
 * @date 17/5/21
 */
public class TubeLight implements Light {

    @Override
    public void turnon() {
        System.out.println("Tube灯 打开");

    }

    @Override
    public void turnoff() {
        System.out.println("Tube灯 关闭");

    }
}
