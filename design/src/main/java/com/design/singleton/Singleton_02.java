package com.design.singleton;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-12 18:18
 **/

/**
 * 懒汉，线程安全
 */
public class Singleton_02 {
    private static Singleton_02 instance;
    private Singleton_02(){}

    public synchronized Singleton_02 getInstance(){
        if(null!=instance){
            return instance;
        }
        instance = new Singleton_02();
        return instance;
    }
}
