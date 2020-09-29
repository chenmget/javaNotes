package com.chem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-29 17:48
 **/
@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaLucyApplication {

    public static void main(String[] args) {
        SpringApplication.run( EurekaLucyApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "zzx") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
