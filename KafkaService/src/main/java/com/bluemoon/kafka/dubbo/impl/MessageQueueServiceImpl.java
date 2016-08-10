package com.bluemoon.kafka.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bluemoon.kafka.dubbo.api.MessageQueueService;
import com.bluemoon.kafka.dubbo.dto.AbstractMessageObject;
import com.bluemoon.kafka.dubbo.tool.SerializeUtil;
import com.bluemoon.kafka.service.KafkaConsumerService;
import com.bluemoon.kafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * Created by LeonWong on 16/7/15.
 */
@Service(version = "0.1")
public class MessageQueueServiceImpl implements MessageQueueService {

    @Autowired
    KafkaService kafkaService;

    @Autowired
    KafkaConsumerService kafkaConsumerService;

    @Override
    public void sendMessage(String topic, String data) {
        kafkaService.sendMessage(topic, data);
    }

    @Override
    public void sendMessage(String topic, AbstractMessageObject data) throws IOException {
        kafkaService.sendMessage(topic, SerializeUtil.serialize(data));
    }

    @Override
    public void onStart() {
        kafkaConsumerService.run();//开始启动消息接收
    }

    @Override
    public void onStop() throws Exception {
        kafkaConsumerService.close();
    }

    @Override
    public String getMessage() {
        Map<Long,String> map=kafkaConsumerService.getMessageMap();
        for (Map.Entry<Long, String> entry : map.entrySet()) {
            System.out.println("---------------key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        return null;
    }
}
