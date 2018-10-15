package com.zhangwen.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhangwen
 * @since 2018/10/15 15:44
 */
@Slf4j
public class FutureTaskExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        FutureTask<String> futureTask = new FutureTask<>(() -> {
            log.info("callable starting");
            Thread.sleep(5000);
            return "callable Done";
        });
        new Thread(futureTask).start();
        log.info("main starting");
        Thread.sleep(2000);
        //未获取到结果会阻塞
        String result = futureTask.get();
        log.info("callable result is: {}", result);
    }
}
