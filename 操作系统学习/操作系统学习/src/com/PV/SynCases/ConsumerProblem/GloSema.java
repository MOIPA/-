package com.PV.SynCases.ConsumerProblem;

import com.PV.UpgradePV.UpSemaphore;
import com.PV.UpgradePV.UpgradeP;
import com.PV.UpgradePV.UpgradeV;

public class GloSema {
    public static UpgradeV V = new UpgradeV();
    public static UpgradeP P = new UpgradeP();
    public static UpSemaphore empty = new UpSemaphore(10); //空间为10
    public static UpSemaphore full = new UpSemaphore(0); //初始为0
    public static UpSemaphore mutex = new UpSemaphore(1); //一次只能有一个人操作
}
