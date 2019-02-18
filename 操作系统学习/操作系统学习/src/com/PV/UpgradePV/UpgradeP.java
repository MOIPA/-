package com.PV.UpgradePV;

/**
 * 这里的synchronized只是为了保证动作的原子性，假如A和B同时访问了
 *
 * 其实，从并发的角度考虑，wait是不能放在synchronized锁里的，会引起死锁。
 * 试考虑，当wait和notify方法都在synchronized锁里的时候，调用wait方法前将对象锁住，然后调用wait方法，线程被挂起，需要其它线程调用notify将其唤醒。
 * 由于notify方法也在synchronized里面，其它线程调用notify的时候要获得对象的锁，但此时锁已经被wait所在的线程持有，而且wait线程已经被挂起，所以notify因为无法获得锁而挂起，这样二者相互等待，导致死锁。
 * Java里面可以将wait和notify放在synchronized里面，是因为Java是这样处理的：
 * 在synchronized代码被执行期间，线程调用对象的wait()方法，会释放对象锁标志，然后进入等待状态，然后由其它线程调用notify()或者notifyAll()方法通知正在等待的线程。
 */
public class UpgradeP {

    public  void P(UpSemaphore semaphore) {

        //p操作 资源-1 并且如果当且资源没得用了 只能对这个资源目标沉睡，但是似乎执行了wait后没有释放对semaphore的锁导致死锁问题
        try {
            synchronized (semaphore) {
//                System.out.println(Thread.currentThread().getName()+"P 获得了semaphore锁");
                semaphore.resCount--;
                if (semaphore.resCount <0) { //资源没了只能等了
//                    System.out.println("P waiting...");
                    semaphore.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
