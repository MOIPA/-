package com.BuilderPattern.AbstractClass;

import com.BuilderPattern.Entity.Wrapper;
import com.BuilderPattern.Interface.Item;
import com.BuilderPattern.Interface.Packing;

public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();

}
