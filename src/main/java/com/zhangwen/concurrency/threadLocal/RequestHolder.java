package com.zhangwen.concurrency.threadLocal;

/**
 * @author zhangwen
 * @since 2018/10/13 23:19
 */
public class RequestHolder {

    private final static ThreadLocal<String> requestHolder = new ThreadLocal<>();

    public static void add(String value){
        requestHolder.set(value);
    }

    public static String get(){
        return requestHolder.get();
    }

    public static void remove(){
        requestHolder.remove();
    }
}
