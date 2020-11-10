package com.design.strategy;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-07 18:30
 **/
public class StrategyMain {
    public static void main(String[] args) {
        Duck d  = new MallardDuck();
        d.performFly();
        d.setFly(new FlyNoWay());
        d.performFly();
    }

}
