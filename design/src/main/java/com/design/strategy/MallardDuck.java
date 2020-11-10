package com.design.strategy;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-07 18:31
 **/
public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
    }
}
