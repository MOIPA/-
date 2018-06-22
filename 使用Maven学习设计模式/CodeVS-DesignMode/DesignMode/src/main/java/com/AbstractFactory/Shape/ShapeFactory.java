package com.AbstractFactory.Shape;
public class ShapeFactory{
    public Shape getShape(String shapeType){
        if(shapeType==null){
            return null;
        }
        if(shapeType.equals("Square")){
            return new Square();
        }else if(shapeType.equals("Rectangle")){
            return new Rectangle();
        }
        return null;
    }
}