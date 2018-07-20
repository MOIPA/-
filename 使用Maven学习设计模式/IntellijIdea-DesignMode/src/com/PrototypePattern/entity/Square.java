package com.PrototypePattern.entity;

import com.PrototypePattern.Interface.Shape;

public class Square extends Shape {
    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method");
    }
}
