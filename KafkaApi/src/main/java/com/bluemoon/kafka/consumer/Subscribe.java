package com.bluemoon.kafka.consumer;

/**
 * 通过注解定义消费端参数
 * <p>
 * Created by LeonWong on 16/8/10.
 */
public @interface Subscribe {

    /**
     * 订阅的主题
     * @return
     */
    String topic();

    /**
     * 消费者分组标识
     * @return
     */
    String group() default "";

    /**
     *消息接收间隔 ms
     * @return
     */
    int interval() default 1000;
}
