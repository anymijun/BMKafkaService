package com.bluemoon.kafka.service;

import com.bluemoon.kafka.config.MessageConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * kafka 服务核心消费者，用于对接kafka topic线程获取消息
 * Created by mijun on 2016/8/8.
 */
@Service
public class KafkaConsumerService implements MessageConsumer {

    @Autowired
    private KafkaConsumer<String, String> mqConsumer;

    private Map<Long,String> messageMap = new LinkedHashMap<Long,String>();

    @Value("${topic}")
    private String topic;

    public Map<Long, String> getMessageMap() {
        return messageMap;
    }

    @Override
    public void run() {
        while (true){
            if (mqConsumer != null) {
                try {
                    Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
                    topicCountMap.put(topic, new Integer(1));
                    mqConsumer.subscribe(Collections.singletonList(this.topic));
                    ConsumerRecords<String, String> records = mqConsumer.poll(100);
                    if(!records.isEmpty() || records.count()>0) {
                        for (ConsumerRecord<String, String> record : records) {
                            System.out.println("service------Received message: (" + record.key() + ", " + record.value() + ") at offset " + record.offset());
                            String ss = record.offset() + "-" + record.value();
                            messageMap.put(record.offset(), record.value());
//                        System.out.println(queue.size());
                        }
                    }
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

    @Override
    public void close() throws Exception {
        mqConsumer.close();
    }


}
