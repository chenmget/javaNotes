package com.design.adapter;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-16 18:43
 **/
public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}
