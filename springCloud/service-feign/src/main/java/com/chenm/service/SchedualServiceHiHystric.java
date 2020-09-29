package com.chenm.service;

import org.springframework.stereotype.Component;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-29 16:39
 **/

@Component
public class SchedualServiceHiHystric  implements ScheduleServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }

}
