package com.PV.UpgradePV;

/**
 * 这里的synchronized只是为了保证动作的原子性
 */
public class UpgradeV {

    public synchronized void V(UpSemaphore semaphore) {
        //V操作 资源+1 并且如果当且资源没得用了 只能对这个资源目标沉睡
        semaphore.resCount++;
        if (semaphore.resCount <= 0) { //资源来了 <=0说明有人在等且有空闲位置 可以叫一个来用了
            synchronized (semaphore) {  //如果不持有对象的锁是没有权力去等待该进程的，会报错误：java.lang.IllegalMonitorStateException
                semaphore.notify();
            }
        }
    }

}
