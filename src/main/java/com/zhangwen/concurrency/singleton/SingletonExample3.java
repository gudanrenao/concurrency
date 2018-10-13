package com.zhangwen.concurrency.singleton;

/**
 * 枚举模式：最安全，推荐
 *
 * @author zhangwen
 * @since 2018/10/12 15:06
 */
public class SingletonExample3 {

    //1.私有构造函数
    private SingletonExample3() {

    }

    public static SingletonExample3 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample3 singletonExample3;

        //JVM保证这个方法绝对只被调用一次
        Singleton() {
            singletonExample3 = new SingletonExample3();
        }

        public SingletonExample3 getInstance() {
            return singletonExample3;
        }
    }
}
