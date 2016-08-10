package com.bluemoon.consumer.bean;

import java.lang.annotation.*;

/**
 * 消息订阅注解接口
 * Created by mijun on 2016/8/9.
 */


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface Subscribe {
    /**
     * 订阅的主题
     * @return
     */
    String  topic() default "";

    /**
     * 分组ID
     * @return
     */
    String groupId() default "";

    /**
     * 分区标识
     * @return
     */
    String partition() default "";











}
