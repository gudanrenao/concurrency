package com.zhangwen.concurrency.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized:修饰代码块、方法，作用于当前对象
 *
 * @author zhangwen
 * @since 2018/10/12 13:46
 */
public class SynchronizedExample1 {

    private final Logger log = LoggerFactory.getLogger(SynchronizedExample1.class);

    //修饰一个代码块
    public void test1(){
        synchronized (this){
            for (int i = 0;i < 30;i++){
                log.info("test1 - {}",i);
            }
        }
    }

    //修饰一个方法
    public synchronized void test2(){
        for (int i = 0;i < 30;i++){
            log.info("test2 - {}",i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(example1::test1);
        executorService.execute(example2::test1);
    }
}
