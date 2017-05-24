package com.gary.strategy.calprice;

/**
 * @author gefengming
 *
 * 消费者
 *
 * @date 17/5/23
 */
public class Customer {

    private String name;

    //消费总金额
    private double totaltotalAmount = 0;

    //单次消费金额
    private double amount;

    //策略后应付金额
    private double afterAmount;

    private CalPrice calPrice = new Common();

    public Customer(String name) {
        this.name = name;
    }

    public void buy(Double amount) {
        this.amount = amount;
        totaltotalAmount = totaltotalAmount + amount;
//        this.calPrice = CalPriceFactory.chooseCalPrice(this);
        this.calPrice = CalPriceFactory.getInstance().chooseCalPriceV2(this);
        this.afterAmount = calPrice.calPrice(amount);
    }

    public String getName() {
        return name;
    }

    public double getTotaltotalAmount() {
        return totaltotalAmount;
    }

    public double getAmount() {
        return amount;
    }

    public CalPrice getCalPrice() {
        return calPrice;
    }

    public double getAfterAmount() {
        return afterAmount;
    }
}
