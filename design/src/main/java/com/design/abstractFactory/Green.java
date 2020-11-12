package com.design.abstractFactory;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-11 14:47
 **/
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
