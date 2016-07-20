package com.bluemoon.log.controller;

import com.bluemoon.log.domain.LogVo;
import com.bluemoon.log.es.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by LeonWong on 16/7/20.
 */
@Controller
@EnableAutoConfiguration
public class ESController {

    @Autowired
    EsService esService;

    @RequestMapping("/insertLog")
    @ResponseBody
    public String index() {
        LogVo logVo = new LogVo();
        logVo.setContent("这是内容(新)");
        logVo.setCrtime(new Date());
        logVo.setWhere("在希望的田野上");
        logVo.setWho("是谁?");
        logVo.setRemark("备注");
        esService.doInsert(logVo);
        return "hello world";
    }
}
