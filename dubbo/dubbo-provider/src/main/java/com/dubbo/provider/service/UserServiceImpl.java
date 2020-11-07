package com.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.common.model.User;
import com.dubbo.common.service.UserService;
import com.dubbo.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-18 15:31
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById() {
        User user = new User();
        user.setName("chenm");
        user.setId(1);
        user.setAge(25);
        return user;
    }

    @Override
    public void addUser(String userId) {
        userMapper.insert(userId);
    }
}
