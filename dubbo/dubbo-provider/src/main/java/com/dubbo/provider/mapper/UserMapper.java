package com.dubbo.provider.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insert(String userId);
}
