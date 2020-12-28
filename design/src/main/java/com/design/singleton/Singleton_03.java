package com.design.singleton;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-12 18:20
 **/

/**
 * 饿汉，线程安全
 */
public class Singleton_03 {
    private static Singleton_03  instance= new Singleton_03();
    private Singleton_03(){

    }
    public static  Singleton_03 getInstance(){
        return instance;
    }
}
