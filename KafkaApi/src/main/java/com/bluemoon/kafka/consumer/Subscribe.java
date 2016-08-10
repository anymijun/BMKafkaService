package com.bluemoon.kafka.consumer;

/**
 * 通过注解定义消费端参数
 * <p>
 * Created by LeonWong on 16/8/10.
 */
public @interface Subscribe {
    String topic();

    String group() default "";

    int interval() default 1000;
}
