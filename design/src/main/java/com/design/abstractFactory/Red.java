package com.design.abstractFactory;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-11 14:44
 **/
public class Red  implements Color{
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
