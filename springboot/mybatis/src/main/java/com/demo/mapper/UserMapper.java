package com.demo.mapper;


import org.apache.ibatis.annotations.Mapper;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-10-10 21:34
 **/
@Mapper
public interface UserMapper {
    void insert(String userId);
}
