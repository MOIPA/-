package com.PV.OriPV;

/**
 * 实现自己的pv操作 由于无法添加自己到进程队列 但是使用wait和notify一样
 */
public class PVObj {
    public synchronized void myP(Semaphore s){
        s.value--;
        if(s.value<0){
            try {
                System.out.println(Thread.currentThread().getName()+" is waiting");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void myV(Semaphore s){
        s.value++;
        if (s.value <= 0) {
            System.out.println(Thread.currentThread().getName()+" is notifying");
            this.notifyAll();
        }
    }
}
