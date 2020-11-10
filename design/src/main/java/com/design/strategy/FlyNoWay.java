package com.design.strategy;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-07 18:29
 **/
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("i cant fly");
    }
}
