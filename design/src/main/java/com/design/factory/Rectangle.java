package com.design.factory;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-11 11:28
 **/
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
