package com.design.abstractFactory;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-11 14:58
 **/
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
