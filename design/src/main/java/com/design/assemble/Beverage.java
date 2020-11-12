package com.design.assemble;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-10 11:14
 **/
public abstract class Beverage {
    String desc = "unknow beverage";

    public  String getDescription(){
        return desc;
    }

    public abstract double cost();
}
