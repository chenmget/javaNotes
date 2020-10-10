package com.eureka.common;

import com.eureka.service.LucyServiceHi;
import org.springframework.stereotype.Component;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-30 09:36
 **/
@Component
public class SchedualServiceHiHystric implements LucyServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}
