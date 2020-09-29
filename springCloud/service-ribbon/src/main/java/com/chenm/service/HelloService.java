package com.chenm.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-29 15:31
 **/

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
            }
    )
    public String hiService(String name) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        String str = restTemplate.getForObject("http://service-hi/hi?name=" + name, String.class);
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.err.println("耗时：" + (endTime - startTime));
        return str;
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }

}
