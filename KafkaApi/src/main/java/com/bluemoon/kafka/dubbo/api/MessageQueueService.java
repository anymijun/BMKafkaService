package com.bluemoon.kafka.dubbo.api;

import com.bluemoon.kafka.dubbo.dto.AbstractMessageObject;

import java.io.IOException;
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
    void sendMessage(String topic, String data);

    /**
     * 发送对象
     *
     * @param topic
     * @param data
     * @return
     */
    void sendMessage(String topic, AbstractMessageObject data) throws IOException;

    /**
     * 启动接收消息
     * @return
     */
    void onStart();

    /**
     * 停止接收
     * @throws Exception
     */
    void onStop() throws Exception;

    /**
     * 开始接收消息
     * @return
     */
    String getMessage();

     }