package com.demo.service.impl;

import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-10-10 21:17
 **/
@Service
public class UserServiceImpl implements UserService {



    @Autowired
    public UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addUser(String userId) {
        userMapper.insert(userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addUserError(String userId) {
        userMapper.insert(userId);
        throw new RuntimeException();
    }


}
