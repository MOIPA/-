package com.AbstractFactory;
import com.AbstractFactory.Shape.*;
import com.AbstractFactory.Color.*;

public class AbstractFactoryPatternDemo{

        public static void main(String[] args) {
                //获取形状工厂
        AbstractFactory shapeFactory =  FactoryProducer.getFactory("shapeFactory");
        //颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("colorFactory");

        System.out.println("the first product \n<===");
        //第一套产品 红的方格
        Shape shape = shapeFactory.getShape("Square");
        Color color = colorFactory.getColor("Red");
        shape.draw();
        color.fill();
        System.out.println("===>");

        System.out.println("the second product \n<===");
        //第二套产品 蓝色的长方形
        Shape shape2 = shapeFactory.getShape("Rectangle");
        shape2.draw();
        Color color2 = colorFactory.getColor("Blue");
        color2.fill();
        System.out.println("===>");

    }

}