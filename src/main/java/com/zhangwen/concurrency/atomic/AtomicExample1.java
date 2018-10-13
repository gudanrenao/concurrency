package com.zhangwen.concurrency.atomic;

import com.zhangwen.concurrency.annotations.ThreadSafe;

/**
 *
 *
 * @author zhangwen
 * @since 2018/10/12 12:29
 */
@ThreadSafe
public class AtomicExample1 {

    public volatile int count = 100;

}
