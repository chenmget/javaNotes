package com.dubbo.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.common.service.UserService;
import com.dubbo.consumer.mapper.OrderMapper;
import com.dubbo.consumer.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
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

    @Reference  //将生产者注册到Dubbo映射到该对象上, 这里完成了服务之间的调用
    private UserService userService;

    @Override
    @GlobalTransactional
    public void addOrder(String userId) {
        orderMapper.insert(userId);
        userService.addUser(userId);
    }
}
