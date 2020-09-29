package com.chenm.controller;

import com.chenm.service.ScheduleServiceHi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-29 16:16
 **/
@RestController
public class HelloController {

    @Resource
    ScheduleServiceHi scheduleServiceHi;

    @RequestMapping(value = "/hello")
    public String hi(@RequestParam String name){
        return "service-feign：" + scheduleServiceHi.sayHiFromClientOne(name);
    }
}
