package com.PV.SynCases.ConsumerProblem;

public class Test {
    public static void main(String[] args) {
        Productor p = new Productor();
        Consumer c = new Consumer();
        new Thread(p).start();
        new Thread(c).start();
    }
}
