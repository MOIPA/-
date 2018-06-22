package com.AbstractFactory;
import com.AbstractFactory.Color.*;
import com.AbstractFactory.Shape.*;
/**
 * 子工厂：图形工厂 不提供颜色
 */

public class ColorFactory extends AbstractFactory{
    public Shape getShape(String shapeType){

        return null;
    }
    public Color getColor(String colorType){
        if(colorType == null) return null;
        if("Red".equals(colorType)){
            return new Red();
        }else if("Blue".equals(colorType)){
            return new Blue();
        }
        return null;
    }
}