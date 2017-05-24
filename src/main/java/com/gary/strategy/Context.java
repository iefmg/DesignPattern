package com.gary.strategy;

/**
 * @author gefengming
 *
 * @date 17/5/22
 */
public class Context {

    private Strategy strategy;

    public Context() {
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        System.out.println("开始任务");
        strategy.algorithm();
        System.out.println("结束任务");
    }
}
