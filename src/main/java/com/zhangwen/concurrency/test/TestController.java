package com.zhangwen.concurrency.test;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author zhangwen
 * @since 2018/10/12 09:04
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    private static ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();

//    public static void main(String[] args) throws FileNotFoundException {
//        Integer a = 100, b = 100, c = 130, d = 130;
//        System.out.println(a == b);
//        System.out.println(c == d);
//        ArrayList<String> list = new ArrayList<>();
//        list.clear();
////        FileInputStream fileInputStream = new FileInputStream(new File(""));
////        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
////        SoftReference<String> softReference = new SoftReference<>("asd");
////        WeakReference<String> weakReference = new WeakReference<>("123", referenceQueue);
//
//        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
//
//        Integer a1 = 1, b1 = 2;
//
//        System.out.println("a1=" + a1 + ",b1=" + b1);
//        swap(a1, b1);
//
//        System.out.println("a1=" + a1 + ",b1=" + b1);
//
//        Integer c1 = 130,c2 = 130;
//        System.out.println(Integer.valueOf(130) == Integer.valueOf(130));
//
//        HashMap map = new HashMap();
//        map.put(1,1);
//        map.size();
//
//    }

    private static void swap(Integer a1, Integer b1) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            int tmp = a1;
            System.out.println("before tmp = " + tmp);
            field.set(a1, b1);
            System.out.println("after tmp = " + tmp);
            field.set(b1, new Integer(tmp));
            System.out.println("end tmp = " + tmp);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static class Node {
        public String value;
        public Node next;


        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", next=" + next +
                    '}';
        }
    }


    public static Node reserve(Node h) {
        Node p = h;//h.next
        Node t = null;
        while (p != null) {
            Node q = p.next;
            p.next = t;
            t = p;
            p = q;
        }
        return t;
    }

    public static void main(String[] args) {
        Node c = new Node("c", null);
        Node b = new Node("b", c);
        Node a = new Node("a", b);

        System.out.println(a.toString());

        Node reserve = reserve(a);

        System.out.println(reserve);

        List list = new ArrayList();
        Map map = new HashMap<>();
        list.iterator().forEachRemaining(e -> System.out.println(1));

    }

}
