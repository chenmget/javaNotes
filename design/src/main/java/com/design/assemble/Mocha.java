package com.design.assemble;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-10 11:21
 **/
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+" ,Mocha";
    }

    @Override
    public double cost() {
        return 0.5+beverage.cost();
    }
}
