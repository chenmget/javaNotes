package com.design.factory;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-11 13:48
 **/
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
