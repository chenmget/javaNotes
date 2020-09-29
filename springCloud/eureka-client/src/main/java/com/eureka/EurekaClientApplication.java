package com.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-29 14:40
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableCircuitBreaker
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run( EurekaClientApplication.class, args);
    }


}
