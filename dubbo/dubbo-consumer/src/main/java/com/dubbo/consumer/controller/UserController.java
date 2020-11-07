package com.dubbo.consumer.controller;

import com.dubbo.consumer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-18 16:14
 **/
@RestController
@RequestMapping("/user")
public class UserController {



    @Autowired
    private OrderService orderService;

//    @RequestMapping("/getUserById")
//    public Object getUserById (){
//        return userService.getUserById();
//    }

    @RequestMapping("/addUser")
    public void addUser (){
        String userId = "2";
        orderService.addOrder(userId);

    }
}
