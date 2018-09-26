package com.PV.OriPV;

import java.awt.*;
import java.util.LinkedList;

public class Semaphore {
    public int value;
    LinkedList list = new LinkedList<Object>(); //无法使用 因为无法实现添加进程到这里

    public Semaphore(int val){
        this.value = val;
    }

}
