package com.agent;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-16 18:35
 **/
public class ApiTest {
    public static void main(String[] args) {
        System.out.println("hello word");
        ApiTest apiTest = new ApiTest();
        apiTest.echoHi();


        //线程一
//        new Thread(() -> new ApiTest().http_lt1()).start();
//
//        //线程二
//        new Thread(() -> { new ApiTest().http_lt1(); }).start();
    }
    private void echoHi(){
        System.out.println("hi agent");
    }


    public void http_lt1() {
        System.out.println("测试结果：hi1");
        http_lt2();
    }

    public void http_lt2() {
        System.out.println("测试结果：hi2");
        http_lt3();
    }

    public void http_lt3() {
        System.out.println("测试结果：hi3");
    }
}
