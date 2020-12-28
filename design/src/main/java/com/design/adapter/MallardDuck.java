package com.design.adapter;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-16 18:42
 **/
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("quack");
    }

    @Override
    public void fly() {
        System.out.println("duck flying");
    }
}
