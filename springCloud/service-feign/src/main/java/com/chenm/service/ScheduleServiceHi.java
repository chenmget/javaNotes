package com.chenm.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-29 16:15
 **/
@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)
public interface ScheduleServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);


}
