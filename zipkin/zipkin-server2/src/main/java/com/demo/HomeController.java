package com.demo;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-18 11:10
 **/


@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private OkHttpClient client;

    private Random random = new Random();

    @RequestMapping("foo")
    public String foo() throws InterruptedException, IOException {
        Random random = new Random();
        int sleep= random.nextInt(100);
        TimeUnit.MILLISECONDS.sleep(sleep);
        String result="foo receive";
        System.out.println(result);
        return " [service2 sleep " + sleep+" ms]" + result;
    }
}