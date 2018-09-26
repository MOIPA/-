package com.PV.UpgradePV;


class A implements Runnable{

    @Override
    public void run() {
        System.out.println("this is A...");
        UpgradeGlobal.V.V(UpgradeGlobal.zeroSemaphore);
    }
}

class B implements Runnable{

    @Override
    public void run() {
        UpgradeGlobal.P.P(UpgradeGlobal.zeroSemaphore);
        System.out.println("this is B...");
    }
}

//目标  保证A先说
public class Sequence2 {
    public static void main(String[] args){
        A a = new A();
        B b = new B();
        new Thread(b).start();
        new Thread(a).start();
    }
}
