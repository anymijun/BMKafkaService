package com.bluemoon.consumer.controller;


import com.bluemoon.consumer.bean.KafkaMessageConsumer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LeonWong on 16/7/19.
 */
@Controller
@EnableAutoConfiguration
public class KafkaConsumerController {




//    @RequestMapping("/")
//    String GetIndex() {
//        return "static/index.html";
//    }


    @RequestMapping("/get")
    @ResponseBody
    public String get() throws Exception {


//        KafkaMessageConsumer consumerThread = new KafkaMessageConsumer("192.168.240.8:9092","test1","consumer-tutorial");
        KafkaMessageConsumer kafkaMessageConsumer=KafkaMessageConsumer.getInstance();
        System.out.println(kafkaMessageConsumer.getQueue().size()+"=============="+kafkaMessageConsumer.getQueue());
        kafkaMessageConsumer.getQueue().poll();

        return "hello world";
    }

    @RequestMapping("/remove")
    @ResponseBody
    public String remove() throws Exception {


//        KafkaMessageConsumer consumerThread = new KafkaMessageConsumer("192.168.240.8:9092","test1","consumer-tutorial");

        System.out.println("=============="+KafkaMessageConsumer.getInstance().getQueue());
//        KafkaMessageConsumer.getInstance().remove();

        return "hello world";
    }

    @RequestMapping("/set")
    @ResponseBody
    public String set() throws Exception {


        return "hello world11111111111111";
    }



    @RequestMapping("/close")
    @ResponseBody
    public String close() throws Exception {

        return "close-Success";
    }
}
