package com.demo.service.impl;

import com.demo.service.OrderService;
import com.demo.service.TestService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-10-10 21:17
 **/
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    public OrderService orderService;

    @Autowired
    public UserService userService;

    @Override
    @Transactional
    public void add(String orderId) {
        orderService.addOrder(orderId);
        userService.addUser(orderId);
        int i=9/0;
    }

    @Override

    public String  select(String id) {
        orderService.select(id);

        return "success";
    }


}
