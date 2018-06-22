package com.AbstractFactory;
import com.AbstractFactory.Color.*;
import com.AbstractFactory.Shape.*;
/**
 * 子工厂：图形工厂 不提供颜色
 */

public class ShapeFactory extends AbstractFactory{
    public Shape getShape(String shapeType){
        if(shapeType == null) return null;
        if("Square".equals(shapeType)){
            return new Square();
        }else if("Rectangle".equals(shapeType)){
            return new Rectangle();
        }
        return null;
    }
    public Color getColor(String colorType){
        return null;
    }
}