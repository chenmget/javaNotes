package com.design.strategy;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-07 18:27
 **/
public abstract class Duck {
    FlyBehavior flyBehavior;

    public void performFly(){
        flyBehavior.fly();
    }

    public void setFly(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }
}
