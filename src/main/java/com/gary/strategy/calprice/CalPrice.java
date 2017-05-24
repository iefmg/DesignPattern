package com.gary.strategy.calprice;

/**
 * @author gefengming
 *
 * 定价策略
 *
 * @date 17/5/23
 */

/**
 * 总价策略接口
 */
public interface CalPrice {

    Double calPrice(Double originalPrice);

}

/**
 * 普通会员总价策略
 * 3000 < 消费金额
 */
@TotalValidRegion(max=3000)
class Common implements CalPrice {
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice;
    }
}

/**
 * VIP会员总价策略
 * 3000 < 消费金额 <= 6000
 */
@TotalValidRegion(min=3000, max=6000)
class VIP implements CalPrice {
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.8;
    }
}

/**
 * 超级会员总价策略
 * 6000 < 消费金额 <= 9000
 */
@TotalValidRegion(min=6000, max=9000)
class SuperVIP implements CalPrice {
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.6;
    }
}

/**
 * 金牌会员总价策略
 * 总消费>9000
 */
@TotalValidRegion(min=9000)
class GoldVIP implements CalPrice {
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.5;
    }
}