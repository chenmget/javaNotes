package com.design.assemble;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-10 11:18
 **/
public class Espresso extends Beverage {

    public Espresso(){
        desc = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
