package com.zhangwen.concurrency.threadLocal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangwen
 * @since 2018/10/13 23:39
 */
@RestController
@Slf4j
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    @GetMapping("/test")
    public String test(){
        log.info("thread value is : {}",RequestHolder.get());
        return RequestHolder.get();
    }
}
