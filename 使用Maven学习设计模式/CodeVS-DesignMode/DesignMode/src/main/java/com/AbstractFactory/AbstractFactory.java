package com.AbstractFactory;

import com.AbstractFactory.Color.Color;
import com.AbstractFactory.Shape.Shape;


/**
 *  这个东西感觉就是个管理所有工厂的大工厂，获取某个工厂，用于生成某个工厂的产品
    优点：当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象。
    缺点：产品族扩展非常困难，要增加一个系列的某一产品，既要在抽象的 Creator 里加代码，又要在具体的里面加代码。
    使用场景： 1、QQ 换皮肤，一整套一起换。 2、生成不同操作系统的程序。
 */
public abstract class AbstractFactory{
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}