package com.bluemoon.kafka.consumer;

/**
 * 消费端监听器务必实现的接口
 *
 * Created by LeonWong on 16/8/9.
 */
public interface MessageListener {

    /**
     * 此方法为消息体获取后的回调
     * 
     * @param data
     */
    void onMessageReceive(Object data);
}
