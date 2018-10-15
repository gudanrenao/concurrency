package com.zhangwen.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author zhangwen
 * @since 2018/10/15 15:44
 */
@Slf4j
public class FutureExample1 {

    static class MyFuture implements Callable<String>{

        @Override
        public String call() throws Exception {
            log.info("callable starting");
            Thread.sleep(5000);
            return "callable Done";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> future = exec.submit(new MyFuture());
        log.info("main starting");
        Thread.sleep(2000);
        //未获取到结果会阻塞
        String result = future.get();
        log.info("callable result is: {}",result);
        exec.shutdown();
    }
}
