package com.bluemoon.kafka.consumer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;

/**
 * 一个Topic对应一个线程来启动轮询消费
 * <p>
 * Created by LeonWong on 16/8/10.
 */
public class KafkaPollingTask implements Runnable {

    /**
     * PS:由于存在多线程环境的可能性,因此每次传入进来的consumer实例务必是不一样的
     */
    private KafkaConsumer consumer;

    /**
     * 由开发者自行实现的监听器实例
     */
    private MessageListener listener;

    private String topic;

    /**
     * 控制轮询时间间隔
     */
    private int interval;

    public KafkaPollingTask(KafkaConsumer consumer, MessageListener listener, String topic, int interval) {
        this.consumer = consumer;
        this.listener = listener;
        this.topic = topic;
        this.interval = interval;
    }

    @Override
    public void run() {
        consumer.subscribe(Collections.singletonList(topic));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("record.value()-------------------"+record.value());
                listener.onMessageReceive(record.value());
            }
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
