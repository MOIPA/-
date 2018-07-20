package com.PrototypePattern.entity;

import com.PrototypePattern.Interface.Shape;

public class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method");
    }
}
