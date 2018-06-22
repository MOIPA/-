package com.AbstractFactory;

public class FactoryProducer{
    public static AbstractFactory getFactory(String factoryType){
        if(factoryType.equals("shapeFactory")){
            return new ShapeFactory();
        }else if(factoryType.equals("colorFactory")){
            return new ColorFactory();
        }
        return null;
    }
}