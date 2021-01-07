package com.demo.controller;


import com.demo.service.OrderService;
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
@RequestMapping("/order")
public class TestController {


    @Autowired
    private OrderService orderService;


    @RequestMapping("/addOrder")
    @GetMapping
    public void addOrder (String orderId){
        orderService.addOrder(orderId);
    }
}
