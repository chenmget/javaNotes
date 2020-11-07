package com.dubbo.consumer.mapper;


import org.apache.ibatis.annotations.Mapper;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-10-10 21:34
 **/
@Mapper
public interface OrderMapper {
    void insert( String userId);
}
