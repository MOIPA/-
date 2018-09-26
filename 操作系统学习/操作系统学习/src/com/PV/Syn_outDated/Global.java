package com.PV.Syn_outDated;

import com.PV.OriPV.PVObj;
import com.PV.OriPV.Semaphore;

public class Global {  //整个pv操作的对象为静态的 这样谁都能调用，这样才能让所有人共享一个对象（静态对象）
                        //如果多个对象调用一个静态的对象是需要synchronized的不然线程不安全
    static Semaphore semaphore = new Semaphore(0);
    static PVObj pvObj = new PVObj();
}
