package com.design.assemble;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-10 11:20
 **/
public class HouseBlend extends Beverage {
    public HouseBlend() {
        desc = "houseblend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
