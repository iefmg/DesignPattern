package com.gary.strategy.calprice;

/**
 * @author gefengming
 *
 * @date 17/5/24
 */
public class TestCalPrice {

    public static void main(String []args) {
        //消费者A 三次消费
        Customer a = new Customer("A");
        a.buy(1000D);
        println(a);
        a.buy(3000D);
        println(a);
        a.buy(5000D);
        println(a);

    }

    public static void println(Customer a){
        System.out.println("消费者:" +a.getName()+ ", 使用消费策略" +a.getCalPrice().getClass().getName()+ ", 购买"+ a.getAmount() +"元商品, 应付" +a.getAfterAmount());
    }
}
