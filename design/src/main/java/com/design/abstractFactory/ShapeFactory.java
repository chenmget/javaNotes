package com.design.abstractFactory;

import com.design.factory.Circle;
import com.design.factory.Rectangle;
import com.design.factory.Shape;
import com.design.factory.Square;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-11 14:51
 **/
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
