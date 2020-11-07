package com.demo.service.impl;

import com.demo.mapper.OrderMapper;
import com.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-10-10 21:17
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    public OrderMapper orderMapper;

    @Override
    public void addOrder(String userId) {
        orderMapper.insert(userId);
    }
}
