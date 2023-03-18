package org.pcdd.javase.tutorial.chapter18_类集框架.ex;

import java.util.*;

public class Main3 {
    /**
     * 一百万
     */
    public static final int N = 1000000;

    public static void addElement(List<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("添加" + N + "个元素耗时：" + (end - start) + "ms");
    }

    public static void main(String[] args) throws Exception {

        List<Integer> list1 = new ArrayList<>();
        addElement(list1);

        List<Integer> list2 = new LinkedList<>();
        addElement(list2);

        List<Integer> list3 = new Vector<>();
        addElement(list3);

        Set<Integer> ts = new TreeSet<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            ts.add(random.nextInt(101));
        }

        for (int temp : ts) {
            System.out.print(temp + " ");
        }


    }

}
