package com.BuilderPattern.AbstractClass;

import com.BuilderPattern.Entity.Bottle;
import com.BuilderPattern.Interface.Item;
import com.BuilderPattern.Interface.Packing;

public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
    
}
