package com.chenm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-29 16:48
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ServiceZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run( ServiceZuulApplication.class, args);
    }

}
