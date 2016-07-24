package com.bluemoon.log.jpa.controller;

import com.bluemoon.log.jpa.domain.City;
import com.bluemoon.log.jpa.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LeonWong on 16/7/22.
 */
@Controller
@EnableAutoConfiguration
public class TestController {

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping("/index")
    @ResponseBody
    public String home() {
        City city = new City("韶关", "广东");
        cityRepository.save(city);
        return "Hello World";
    }
}
