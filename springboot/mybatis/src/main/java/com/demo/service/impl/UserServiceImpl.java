package com.demo.service.impl;

import com.demo.mapper.OrderMapper;
import com.demo.mapper.UserMapper;
import com.demo.service.OrderService;
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
public class TestServiceImpl implements OrderService {

    @Autowired
    public OrderMapper orderMapper;

    @Autowired
    public UserMapper userMapper;

    @Override
    @Transactional
    public void addOrder(String orderId) {
        insertOrder(orderId);
        addUser();
    }

    private void addUser(){
        String userId = "1";
        userMapper.insert(userId);
    }

    private void insertOrder(String orderId){
        orderMapper.insert(orderId);
    }
}
