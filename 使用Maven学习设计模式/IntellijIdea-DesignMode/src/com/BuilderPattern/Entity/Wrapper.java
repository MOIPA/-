package com.BuilderPattern.Entity;

import com.BuilderPattern.Interface.Packing;

public class Wrapper implements Packing {
    @Override
    public String packing() {
        return "Wrapper";
    }
}
