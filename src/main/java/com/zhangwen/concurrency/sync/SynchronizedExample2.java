package com.zhangwen.concurrency.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized:修饰静态方法、类，作用于当前类的所有对象
 *
 * @author zhangwen
 * @since 2018/10/12 13:46
 */
public class SynchronizedExample2 {

    private static final Logger log = LoggerFactory.getLogger(SynchronizedExample2.class);

    //修饰当前类
    public void test1(int j){
        synchronized (SynchronizedExample2.class){
            for (int i = 0;i < 10;i++){
                log.info("test1 - {} - {}",j,i);
            }
        }
    }

    //修饰静态方法
    public static synchronized void test2(int j){
        for (int i = 0;i < 10;i++){
            log.info("test2 - {} - {}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> example1.test1(1));
        executorService.execute(() -> example2.test1(2));
    }
}
