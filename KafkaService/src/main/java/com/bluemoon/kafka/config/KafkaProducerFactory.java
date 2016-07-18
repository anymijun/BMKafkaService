package com.bluemoon.kafka.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Properties;

/**
 * Kafka生产者工厂
 * 
 * Created by LeonWong on 16/7/15.
 */
@Configuration
@ConfigurationProperties(prefix = "kafka")
public class KafkaProducerFactory {

    private List<String> clusters;

    private Integer batchsize;

    private Integer buffermemory;

    private Integer retries = 0;

    @Bean(name = "mqProducer")
    public Producer getInstance() {
        Assert.notNull(clusters);
        /**
         * 参考文档
         *
         * @URL http://kafka.apache.org/documentation.html#configuration
         */
        Properties props = new Properties();
        props.put("bootstrap.servers", clusters);
        props.put("acks", "all");
        props.put("retries", retries);
        props.put("batch.size", batchsize);
        props.put("linger.ms", 1);
        props.put("buffer.memory", buffermemory);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return new KafkaProducer<>(props);
    }

    public List<String> getClusters() {
        return clusters;
    }

    public void setClusters(List<String> clusters) {
        this.clusters = clusters;
    }

    public Integer getBuffermemory() {
        return buffermemory;
    }

    public void setBuffermemory(Integer buffermemory) {
        this.buffermemory = buffermemory;
    }

    public Integer getBatchsize() {
        return batchsize;
    }

    public void setBatchsize(Integer batchsize) {
        this.batchsize = batchsize;
    }

    public Integer getRetries() {
        return retries;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }
}