package com.bluemoon.kafka.controller;

import com.bluemoon.kafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller层(测试Dubbo服务用)
 *
 * Created by LeonWong on 16/7/15.
 */
@Controller
@EnableAutoConfiguration
public class KafkaController {

    @Autowired
    KafkaService kafkaService;

    @RequestMapping("/home")
    @ResponseBody
    public String index() {
        kafkaService.sendMessage("consumer-tutorial", "这是内容");
        return "hello world";
    }
}
