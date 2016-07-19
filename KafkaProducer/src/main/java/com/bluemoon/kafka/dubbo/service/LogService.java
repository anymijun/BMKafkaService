package com.bluemoon.kafka.dubbo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bluemoon.kafka.dubbo.api.MessageQueueService;
import org.springframework.stereotype.Service;

/**
 * Created by LeonWong on 16/7/19.
 */
@Service
public class LogService {

    @Reference(version = "0.1")
    public MessageQueueService messageQueueService;

    /**
     * 测试通过dubbox 发送消息到mq
     * 
     * @param msg
     */
    public void doSendMessage(String msg) {
        messageQueueService.sendMessage("consumer-tutorial", msg);
    }
}
