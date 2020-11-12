package com.design.factory;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-11 13:49
 **/
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
