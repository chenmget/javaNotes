package com.dubbo.main;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-18 16:12
 **/
@SpringBootApplication
@EnableDubbo  //启动dubbo的配置
public class DubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

}