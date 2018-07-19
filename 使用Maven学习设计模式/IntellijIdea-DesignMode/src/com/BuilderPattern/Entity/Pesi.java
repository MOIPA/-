package com.BuilderPattern.Entity;

import com.BuilderPattern.AbstractClass.ColdDrink;

public class Pesi extends ColdDrink {
    @Override
    public String name() {
        return "Pesi";
    }

    @Override
    public float price() {
        return 10.1f;
    }
}
