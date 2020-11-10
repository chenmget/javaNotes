package com.design.strategy;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-07 18:29
 **/
public class FlyWithWings implements  FlyBehavior {
    @Override
    public void fly() {
        System.out.println("fly with wings");
    }
}
