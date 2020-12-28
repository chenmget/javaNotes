package com.design.adapter;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-16 18:42
 **/
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble");
    }

    @Override
    public void fly() {
        System.out.println("turkey fly");
    }
}
