package com.zhangwen.concurrency.immutable;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * 不可变对象
 * Collections.unmodifiableXXX  如Collection List Set Map
 * ImmutableXXX  如Collection List Set Map
 * @author zhangwen
 * @since 2018/10/13 19:47
 */
@Slf4j
public class ImmutableExample1 {

    private static Map<Integer,Integer> map = Maps.newHashMap();

    private static ImmutableMap<Integer,Integer> immutableMap = ImmutableMap.<Integer,Integer>builder().put(1,2).put(3,4).build();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        log.info("map 1 == {}",map.get(1));
    }
}
