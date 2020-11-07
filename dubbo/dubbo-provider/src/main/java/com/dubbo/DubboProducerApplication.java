package com.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-18 16:12
 **/
@SpringBootApplication
@EnableDubbo
@MapperScan("mapper")
public class DubboProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboProducerApplication.class, args);
    }

}