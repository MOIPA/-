package com.PV.UpgradePV;

/**
 * 提供资源数量和进入队列，还是不可以直接将进程放入队列，但是可以通过synchronized和操作一个共同变量来成为semaphore上等待的对象
 * a b都试图用semaphore修改资源数量就可以了，将修改资源数量的操作变为synchronized
 *
 * 问题：但是操作这个变量很快就结束了，wait操作还是在pv上执行所以各自还是在pv两个类上等待，试试对象.wait
 */
public class UpSemaphore {
    public int resCount = 0;//资源数量 默认为0

    public UpSemaphore(int resCountNew){
        this.resCount = resCountNew;
    }

}
