package com.zhangwen.concurrency.test;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangwen
 * @since 2018/10/12 09:04
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

}
