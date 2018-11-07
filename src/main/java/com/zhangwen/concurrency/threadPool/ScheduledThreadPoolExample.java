package com.zhangwen.concurrency.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangwen
 * @since 2018/10/15 16:52
 */
@Slf4j
public class ScheduledThreadPoolExample {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        executorService.schedule(() -> {
            log.info("schedule running");
        }, 3, TimeUnit.SECONDS);
        log.info("main ...");
        executorService.shutdown();
    }
}
