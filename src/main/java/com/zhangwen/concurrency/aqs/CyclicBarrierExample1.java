package com.zhangwen.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author zhangwen
 * @since 2018/10/14 22:59
 */
@Slf4j
public class CyclicBarrierExample1 {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
        log.info("after........");
    });

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        int threadCount = 20;
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            exec.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }

    public static void test(int i) throws Exception {
        Thread.sleep(1000);
        log.info("thread is {}", i);
        cyclicBarrier.await();
        log.info("thread {} continue",i);
    }
}
