package com.zhangwen.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangwen
 * @since 2018/10/14 22:59
 */
@Slf4j
public class SemaphoreExample1 {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        int threadCount = 20;
        //同时执行数量
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
//                    semaphore.acquire(2);
//                    test(threadNum);
//                    semaphore.release(2);
                    if (semaphore.tryAcquire(2, TimeUnit.SECONDS)) {
                        test(threadNum);
                        semaphore.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        exec.shutdown();
    }

    public static void test(int i) throws InterruptedException {
        Thread.sleep(500);
        log.info("thread is {}", i);
    }
}
