package com.SingleTon.HungerMode;
public class SingleObject{
    
    //为本身创建静态对象  恶汉式，在类加载时就初始化 没有加锁
    private static SingleObject instance = new SingleObject();
    //将构造方法私有化以防止被实例化
    private SingleObject(){};

    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("the singleTon object is Showing Message...");
    }

}