package com.bluemoon.kafka.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bluemoon.kafka.dubbo.api.MessageQueueService;
import com.bluemoon.kafka.dubbo.dto.AbstractMessageObject;
import com.bluemoon.kafka.dubbo.tool.SerializeUtil;
import com.bluemoon.kafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.Future;

/**
 * Created by LeonWong on 16/7/15.
 */
@Service(version = "0.1")
public class MessageQueueServiceImpl implements MessageQueueService {

    @Autowired
    KafkaService kafkaService;

    @Override
    public Future sendMessage(String topic, String data) {
        return kafkaService.sendMessage(topic, data);
    }

    @Override
    public Future sendMessage(String topic, AbstractMessageObject data) throws IOException {
        return kafkaService.sendMessage(topic, SerializeUtil.serialize(data));
    }
}
