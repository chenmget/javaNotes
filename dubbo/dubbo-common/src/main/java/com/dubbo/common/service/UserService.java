package com.dubbo.common.service;

import com.dubbo.common.model.User;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-18 15:30
 **/
public interface UserService {
    User getUserById();

    void addUser(String userId);


}
