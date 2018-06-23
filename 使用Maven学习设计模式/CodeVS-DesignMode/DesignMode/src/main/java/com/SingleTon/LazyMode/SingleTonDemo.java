package com.SingleTon.LazyMode;
public class SingleTonDemo{
    public static void main(String[] args) {
        SingleObject singleObject = SingleObject.getInstance();
        singleObject.showMessage();
    }
}