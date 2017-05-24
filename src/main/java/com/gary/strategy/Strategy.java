package com.gary.strategy;

/**
 * @author gefengming
 *
 * 策略
 *
 * @date 17/5/22
 */

public interface Strategy {
    void algorithm();
}

class ConcreteStrategyA implements Strategy{
    @Override
    public void algorithm() {
        System.out.println("执行策略A");
    }
}

class ConcreteStrategyB implements Strategy{
    @Override
    public void algorithm() {
        System.out.println("执行策略B");
    }
}

class ConcreteStrategyC implements Strategy{
    @Override
    public void algorithm() {
        System.out.println("执行策略C");
    }
}
