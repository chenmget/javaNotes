package com.design.assemble;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-10 15:10
 **/
public class AssembleMain {
    public static void main(String[] args) {
        Beverage b1 = new Espresso();
        Beverage b2 = new HouseBlend();

        b1 = new Mocha(b1);
        System.out.println(b1.getDescription() + b1.cost());

        b2 = new Mocha(b2);
        b2 = new Mocha(b2);
        System.out.println(b2.getDescription() + b2.cost());
    }
}
