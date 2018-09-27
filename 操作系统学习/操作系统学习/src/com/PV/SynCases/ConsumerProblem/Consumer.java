package com.PV.SynCases.ConsumerProblem;

public class Consumer implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            GloSema.P.P(GloSema.full);
            GloSema.P.P(GloSema.mutex);
            System.out.println("consumed an product... times:"+i);
            GloSema.V.V(GloSema.mutex);
            GloSema.V.V(GloSema.empty);

        }
    }
}
