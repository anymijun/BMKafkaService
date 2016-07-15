package com.bluemoon.kafka.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 考虑一个系统多个Topic的封装场景
 *
 * Created by LeonWong on 16/7/15.
 */
@Configuration
public class KafkaProducerFactory {

    /**
     * 默认TOPIC
     *
     * @TODO 打算写入配置
     */
    private static final String KAFKA_CLUSTER = "127.0.0.1:9092";

    @Bean(name = "mqProducer")
    public Producer getInstance() {
        /**
         * 参考文档
         *
         * @URL http://kafka.apache.org/documentation.html#configuration
         */
        Properties props = new Properties();
        props.put("bootstrap.servers", KAFKA_CLUSTER);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, Object> producer = new KafkaProducer<>(props);
        return producer;
    }

}