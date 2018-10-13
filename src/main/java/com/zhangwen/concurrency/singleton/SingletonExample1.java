package com.zhangwen.concurrency.singleton;

/**
 * 懒汉模式：双重同步锁单例模式
 * 为保证线程安全 单例对象需使用 volatile声明(禁止指令重排) + 双重检测机制
 * @author zhangwen
 * @since 2018/10/12 15:06
 */
public class SingletonExample1 {

    //1.私有构造函数
    private SingletonExample1(){

    }

    //实例化步骤分为三步：
    //1.分配对象的内存空间 memory = allocate()
    //2.初始化对象  ctorInstance()
    //3.instance = memory

    private volatile static SingletonExample1 instance = null;

    public static SingletonExample1 getInstance(){
        if(instance == null){ //第一重检测
            synchronized (SingletonExample1.class){
                if(instance == null){
                    //如果指令重排，按着1，3，2的顺序执行，加入a线程执行3步骤时，b线程执行到第一重检测，会发现instance != null,直接返回，这是对象其实还没有初始化完成
                    //为了防止指令重排，instance需要volatile修饰
                    instance = new SingletonExample1();
                }
            }
        }
        return instance;
    }
}
