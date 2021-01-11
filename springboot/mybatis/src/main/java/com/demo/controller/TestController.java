package com.demo.controller;


import com.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-18 16:14
 **/
@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    private TestService testService;


    @RequestMapping("/add")
    @GetMapping
    public void add (String id){
        testService.add(id);
    }

    @RequestMapping("/select")
    @GetMapping
    public String  select (String id){
        return testService.select(id);
    }
}
