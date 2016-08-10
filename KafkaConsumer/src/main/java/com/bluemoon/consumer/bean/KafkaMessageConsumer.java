package com.bluemoon.consumer.bean;

import org.apache.kafka.clients.consumer.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by mijun on 2016/8/3.
 */

public class KafkaMessageConsumer implements MessageConsumer {

    private final KafkaConsumer<String, String> consumer;
    private  Queue<String> queue = new ConcurrentLinkedQueue<String>();

    private final String topic;

    private static final KafkaMessageConsumer kafkaMessageConsumer = new KafkaMessageConsumer("192.168.240.8:9092","test1","consumer-tutorial");


    //静态工厂方法
    public static KafkaMessageConsumer getInstance() {
        return kafkaMessageConsumer;
    }


    public KafkaMessageConsumer(final String metadataBrokerList,
                                final String groupId,
                                final String topic) {

        final Properties props = new Properties();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, metadataBrokerList);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "10000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");


        this.consumer = new KafkaConsumer<String, String>(props);
        this.topic = topic;

    }


    @Override
    public Object call() throws Exception {
        while (true){
            if (consumer != null) {
                try {
                    Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
                    topicCountMap.put(topic, new Integer(1));
                    consumer.subscribe(Collections.singletonList(this.topic));
                    ConsumerRecords<String, String> records = consumer.poll(100);
                    for (ConsumerRecord<String, String> record : records){
                        System.out.println("Received message: (" + record.key() + ", " + record.value() + ") at offset " + record.offset());
                        String ss=record.offset()+"-"+record.value();
                        queue.add(ss);
//                        System.out.println(queue.size());
                    }
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            }

        }
    }


    @Override
    public void close() throws Exception {
        this.consumer.close();
    }

    /**
     * 获取存储消息的队列对象；
     *
     * @return 存储消息的队列对象；
     */
    public Queue<String> getQueue() {
        return queue;
    }

    public void remove() {
        queue.remove();
    }


}
