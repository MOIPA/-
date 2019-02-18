package com.PV.SynCases.ConsumerProblem;

public class Productor implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {

            GloSema.P.P(GloSema.empty);
            GloSema.P.P(GloSema.mutex);
            System.out.println("productor producted an item times:"+i);
            GloSema.V.V(GloSema.mutex);
            GloSema.V.V(GloSema.full);
        }

    }
}
