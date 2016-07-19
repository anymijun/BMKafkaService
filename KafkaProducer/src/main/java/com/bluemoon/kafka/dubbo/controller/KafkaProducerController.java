package com.bluemoon.kafka.dubbo.controller;

import com.bluemoon.kafka.dubbo.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LeonWong on 16/7/19.
 */
@Controller
@EnableAutoConfiguration
public class KafkaProducerController {

    @Autowired
    BusinessService businessService;

    @RequestMapping("/sendDubboMessage")
    @ResponseBody
    public String index() {
        businessService.doSendMessage("这是内容");
        return "hello world";
    }
}
