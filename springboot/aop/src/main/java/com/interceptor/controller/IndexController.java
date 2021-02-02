package com.interceptor.controller;

import com.aop.annotations.MyLog;
import com.interceptor.annotations.LoginRequired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2021-01-18 19:42
 **/
@RestController
public class IndexController {

    //127.0.0.1:8082/sourceA
    @GetMapping("/sourceA")
    @LoginRequired
    public String sourceA(){
        return "你正在访问A";
    }

    @GetMapping("/sourceB")
    @MyLog
    public String sourceB(){
        System.out.println("打印一下");
        return "你正在访问B";
    }
}
