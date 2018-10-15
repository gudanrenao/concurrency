package com.zhangwen.concurrency.lock;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhangwen
 * @since 2018/10/15 14:43
 */
public class ReentrantReadWriteLockExample {

    private static Map<String, MyData> map = new TreeMap<>();

    private final static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final static Lock readLock = lock.readLock();
    private final static Lock writeLock = lock.writeLock();

    public MyData get(String key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public Set<String> getAllKeys() {
        readLock.lock();
        try {
            return map.keySet();
        } finally {
            readLock.unlock();
        }
    }

    public MyData put(String key, MyData newData) {
        writeLock.lock();
        try {
            return map.put(key, newData);
        } finally {
            writeLock.unlock();
        }
    }

    private static class MyData {
    }
}
