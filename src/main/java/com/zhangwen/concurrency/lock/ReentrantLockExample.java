package com.zhangwen.concurrency.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangwen
 * @since 2018/10/14 22:59
 */
@Slf4j
public class ReentrantLockExample {

    private final static int clientCount = 5000;
    private final static int threadCount = 200;

    private static int count = 0;

    private final static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(clientCount);
        //同时执行线程数
        Semaphore semaphore = new Semaphore(threadCount);
        for (int i = 0; i < clientCount; i++) {
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        log.info("count result = {}", count);
        exec.shutdown();
    }

    public static void add() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
