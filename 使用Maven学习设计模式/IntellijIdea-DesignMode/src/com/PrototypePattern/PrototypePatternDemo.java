package com.PrototypePattern;

import com.PrototypePattern.Interface.Shape;

public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape clonedShapeA = ShapeCache.getShape("1");
        clonedShapeA.draw();
        clonedShapeA.setType("clonedShape");
        System.out.println(clonedShapeA.getType());
        Shape clonedShapeB = ShapeCache.getShape("1");
        System.out.println(clonedShapeB.getType());
    }
}
