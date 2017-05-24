package com.gary.strategy;

/**
 * @author gefengming
 * @date 17/5/22
 */
public class Client {

    public static void main(String[] args){

        Context context = new Context();

        context.setStrategy(new ConcreteStrategyA());
        context.execute();

        context.setStrategy(new ConcreteStrategyB());
        context.execute();

        context.setStrategy(new ConcreteStrategyC());
        context.execute();
    }

}

