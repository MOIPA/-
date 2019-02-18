package com.PV.OriPV;

/**
 * 实现自己的pv操作 由于无法添加自己到进程队列 但是使用wait和notify一样 都会进入系统的某个对象等待队列
 * 这就导致我pv操作的时候P（S）的信号量内不存在进程列表，而是直接存在PV类的系统等待队列===》所以和书上的区别在于只是把等待队列放到了PVObj内部
 *
 * synchronized关键字的作用域有二种：
 * 1：某个对象实例内，synchronized aMethod(){}可以防止多个线程同时访问这个对象的synchronized方法（如果一个对象有多个synchronized方法，
 * 只要一个线 程访问了其中的一个synchronized方法，其它线程不能同时访问这个对象中任何一个synchronized方法）。
 * 这时，不同的对象实例的 synchronized方法是不相干扰的。也就是说，其它线程照样可以同时访问相同类的另一个对象实例中的synchronized方法；
 * 2：某个类的范围，synchronized static aStaticMethod{}防止多个线程同时访问这个类中的synchronized static 方法。它可以对类的所有对象实例起作用。
 *
 * 静态变量是被类的所有调用者共享的所以是非线程安全的
 *
 *   synchronized是对类的当前实例进行加锁，防止其他线程同时访问该类的该实例的所有synchronized块，注意这里是“类的当前实例”，
 *   类的两个不同实例就没有这种约束了。那么static synchronized恰好就是要控制类的所有实例的访问了=====》这里没必要static synchronized 一个
 *
 * 结论：所以当A线程访问第一个synchronized时候获得了整个PVObj类的锁，在第二个线程试图访问任何一个synchronized时候只能等待，所以当A阻塞的时候释放对PVObj的锁
 * 进入的是对PVObj的类等待队列，当B线程获得PVObj的锁进入执行唤醒操作的时候 唤醒的也是等待这个对象的队列的A进程
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
            this.notify();
        }
    }
}
