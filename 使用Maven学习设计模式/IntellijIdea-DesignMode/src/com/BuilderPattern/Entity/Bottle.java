package com.BuilderPattern.Entity;

import com.BuilderPattern.Interface.Packing;

public class Bottle implements Packing {
    @Override
    public String packing() {
        return "Bottle";
    }
}
