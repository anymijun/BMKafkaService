package com.bluemoon.kafka.config;

import java.util.concurrent.Callable;

/**
 * 消费者统一接口，extends 线程与资源自动关闭的接口AutoCloseable（jdk1.7引入）
 * Created by mijun on 2016/8/3.
 */
public interface MessageConsumer extends Runnable,AutoCloseable{
}
