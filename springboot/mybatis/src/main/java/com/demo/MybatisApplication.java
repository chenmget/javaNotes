package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-10-11 17:19
 **/
@SpringBootApplication
@MapperScan("com.demo.mapper.*")//使用MapperScan批量扫描所有的Mapper接口；
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

}
