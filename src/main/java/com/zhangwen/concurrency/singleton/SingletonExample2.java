package com.zhangwen.concurrency.singleton;

/**
 * 饿汉模式：单例实例在类装载时进行创建
 *
 * @author zhangwen
 * @since 2018/10/12 15:06
 */
public class SingletonExample2 {

    //1.私有构造函数
    private SingletonExample2() {

    }

    //方法一 直接声明时初始化
//    private static SingletonExample2 instance = new SingletonExample2();

    //方法二 静态代码块初始化，注意：代码块需要放在下面，因为静态域、静态代码块是按照代码书写顺序执行
    private static SingletonExample2 instance = null;
    static {
        instance = new SingletonExample2();
    }

    public static SingletonExample2 getInstance() {
        return instance;
    }
}
