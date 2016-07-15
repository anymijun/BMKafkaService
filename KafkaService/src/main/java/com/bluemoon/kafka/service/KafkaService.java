package com.bluemoon.kafka.service;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * Created by LeonWong on 16/7/15.
 */
@Service
public class KafkaService {

    @Autowired
    private Producer<String, Object> mqProducer;

    /**
     * 发送字符串
     *
     * @param topic
     * @param dataStr
     * @return
     */
    public Future<RecordMetadata> sendMessage(String topic, String dataStr) {
        return mqProducer.send(new ProducerRecord<String, Object>(topic, dataStr));
    }

    /**
     * 发送二进制码
     *
     * @param topic
     * @param objSerialize
     * @return
     */
    public Future sendMessage(String topic, byte[] objSerialize) {
        return mqProducer.send(new ProducerRecord<String, Object>(topic, objSerialize));
    }
}

