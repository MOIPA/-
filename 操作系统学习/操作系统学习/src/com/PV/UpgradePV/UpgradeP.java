package com.PV.UpgradePV;

/**
 * 这里的synchronized只是为了保证动作的原子性
 */
public class UpgradeP {

    public synchronized void P(UpSemaphore semaphore) {
        //p操作 资源-1 并且如果当且资源没得用了 只能对这个资源目标沉睡
        semaphore.resCount--;
        try {
            if(semaphore.resCount<=-1) { //资源没了只能等了
                synchronized (semaphore){
                    semaphore.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
