package com.eureka.controller;

import com.eureka.service.LucyServiceHi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-29 17:25
 **/
@RestController
public class Controller {
    @Value("${server.port}")
    String port;

    @Resource
    LucyServiceHi lucyServiceHi;

    @RequestMapping(value = "/hiLucy")
    public String hiLucy(@RequestParam String name){
        String str = lucyServiceHi.sayHiFromClientOne(name);
        return str;
    }


    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
