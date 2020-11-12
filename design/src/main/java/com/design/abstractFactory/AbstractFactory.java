package com.design.abstractFactory;

import com.design.factory.Shape;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-11 14:48
 **/
public abstract  class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
