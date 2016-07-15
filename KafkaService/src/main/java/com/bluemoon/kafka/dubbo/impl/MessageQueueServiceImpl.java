package com.bluemoon.kafka.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bluemoon.kafka.dubbo.api.MessageQueueService;
import com.bluemoon.kafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Future;

/**
 * Created by LeonWong on 16/7/15.
 */
@Service(version = "0.1")
public class MessageQueueServiceImpl implements MessageQueueService {

    @Autowired
    KafkaService kafkaService;

    @Override
    public Future sendMessage(String topic, byte[] data) {
        return null;
    }

    @Override
    public Future sendMessage(String topic, String data) {
        return null;
    }
}
