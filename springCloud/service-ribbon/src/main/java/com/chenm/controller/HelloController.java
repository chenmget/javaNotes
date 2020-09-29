package com.chenm.controller;

import com.chenm.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-29 15:31
 **/

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) throws InterruptedException {
        return "service-ribbon：" + helloService.hiService(name);
    }

}
