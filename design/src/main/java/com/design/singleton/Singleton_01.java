package com.design.singleton;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-12 18:16
 **/

/**
 * 懒汉，线程非安全
 */
public class Singleton_01 {
    public static Singleton_01 instance;

    private Singleton_01(){}

    public Singleton_01 getInstance(){
        if(null!=instance){
            return instance;
        }
        instance = new Singleton_01();
        return instance;
    }
}
