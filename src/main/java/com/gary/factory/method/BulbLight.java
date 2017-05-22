package com.gary.factory.method;

/**
 * @author gefengming
 *
 * @date 17/5/21
 */
public class BulbLight implements Light{

    @Override
    public void turnon() {
        System.out.println("Bulb灯 打开");
    }

    @Override
    public void turnoff() {
        System.out.println("Bulb灯 关闭");
    }
}
