package com.BuilderPattern.Entity;

import com.BuilderPattern.AbstractClass.Burger;

public class VegBurger extends Burger {
    @Override
    public String name() {
        return "VegBurger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
