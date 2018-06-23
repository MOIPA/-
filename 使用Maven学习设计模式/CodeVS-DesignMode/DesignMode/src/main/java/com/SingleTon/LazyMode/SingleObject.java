package com.SingleTon.LazyMode;
public class SingleObject{
    
    //为本身创建静态对象  懒汉式 只有在被调用才初始化，为了防止多线程同时初始化所以要加锁  节省内存但是效率不高
    private static SingleObject instance = null;
    //将构造方法私有化以防止被实例化
    private SingleObject(){};

    public static synchronized SingleObject getInstance(){
        if(instance==null){
            instance = new SingleObject();
        }
        return instance;
    }

    public void showMessage(){
        System.out.println("[lazy mode]the singleTon object is Showing Message...");
    }

}