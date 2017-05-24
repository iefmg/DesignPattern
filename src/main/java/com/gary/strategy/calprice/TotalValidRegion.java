package com.gary.strategy.calprice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author gefengming
 *
 * 总价策略注解
 *
 * @date 17/5/24
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TotalValidRegion {

    int max() default Integer.MAX_VALUE;

    int min() default Integer.MIN_VALUE;

}
