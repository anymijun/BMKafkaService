package com.bluemoon.consumer.bean;


import java.util.concurrent.Callable;

/**
 * Created by mijun on 2016/8/3.
 */
public interface MessageConsumer extends Callable<Object>,AutoCloseable{
}
