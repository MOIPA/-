package com.PV.UpgradePV;

/**
 * 这里的synchronized只是为了保证动作的原子性
 * 我似乎犯了一个很严重的错误：在操作semaphore时就得确保获取了这个共享资源，没有其他人可以获取，包括操作资源数量
 */
public class UpgradeV {

    public  void V(UpSemaphore semaphore) {

        //V操作 资源+1 并且如果当且资源没得用了 只能对这个资源目标沉睡
        synchronized (semaphore) {  //如果不持有对象的锁是没有权力去等待该进程的，会报错误：java.lang.IllegalMonitorStateException
//            System.out.println(Thread.currentThread().getName()+"V 获得了semaphore锁");
            semaphore.resCount++;
            if (semaphore.resCount <= 0) { //资源来了 <=0说明有人在等且有空闲位置 可以叫一个来用了
//                System.out.println("V notifying...");
                semaphore.notify();
            }
        }
    }

}
