package com.bluemoon.kafka.dubbo.api;

import java.util.concurrent.Future;

/**
 * Created by LeonWong on 16/7/15.
 */
public interface MessageQueueService {

    /**
     * 发送字符串消息
     *
     * @param topic
     * @param data
     * @return
     */
    Future sendMessage(String topic, String data);

    /**
     * 发送二进制序列化后的消息
     *
     * @param topic
     * @param data
     * @return
     */
    Future sendMessage(String topic, byte[] data);
}