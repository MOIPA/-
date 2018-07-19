package com.BuilderPattern.Entity;

import com.BuilderPattern.AbstractClass.ColdDrink;

public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 8.1f;
    }
}
