package com.PV.OriPV;

import java.util.LinkedList;

/**
 * 开始实现基本的信号量和pv操作
 * 实现思路： 首先我需要一个公共的信号量，为了显示资源和将进程放入等待队列，但是不能做到后一种
 * 其次我需要一个公共的pv操作，因为p是消耗资源进入等待区域，v是提供资源唤醒等待者，所以这个pv操作的类可以在同一个类中共享一个semaphore信号量
 * 在java中，恰好使用synchronized可以完成原子操作所以pv都是需要加这个的，又因为只能将等待队列放在某个对象上所以可以放在pv在一个类上，如果pv不是一个类
 * 那么会导致p等待的是对p的类的队列，v唤醒的是等待v类的队列，所以pv在一个类里，（这里似乎和队列放在semaphore中不一样，之后可以试试把等待队列转移到semaphore上）
 *
 */
public class Semaphore {
    public int value;
    LinkedList list = new LinkedList<Object>(); //无法使用 因为无法实现添加进程到这里

    public Semaphore(int val){
        this.value = val;
    }

}
