package com.PV.Syn;

import com.PV.OriPV.Semaphore;

/**
 * 目的：让期中一个先执行 后一个缓慢执行
 */
class P1 implements Runnable{

    @Override
    public void run() {
        Global.pvObj.myP(Global.s1);
        System.out.println("P1 Say Hi!");
    }
}
class P2 implements Runnable{

    @Override
    public void run() {
        Global.pvObj.myV(Global.s1);
        System.out.println("P2 Say Hi!");
    }
}

public class Sequence {
    private Semaphore S = new Semaphore(0);

    public static void main(String[] args) {
        P1 p1 = new P1();
        P2 p2 = new P2();
        new Thread(p1).start();
        new Thread(p2).start();
    }
}
