package org.pcdd.javase.experimental.arraylist和linkedlist插入速度对比;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pcdd
 * date 2021/4/9 23:56
 */
public class TestMain {
    /**
     * 1 * 2^17
     */
    public static final int N = 1 << 17;

    public static void main2(String[] args) {
        long start = 0;
        long end = 0;

        List<Integer> arrayList = new ArrayList<>();

        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            arrayList.add(i + 1);
        }
        end = System.currentTimeMillis();
        System.out.format("ArrayList后部插入：%dms\n", end - start);

        List<Integer> linkedList = new LinkedList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            linkedList.add(i);
        }
        end = System.currentTimeMillis();
        System.out.format("LinkedList 后部插入：%dms\n", end - start);

        /*arrayList.clear();
        linkedList.clear();

        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            arrayList.add(0, i);
        }
        end = System.currentTimeMillis();
        System.out.format("ArrayList 前部插入：%dms\n", end - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            linkedList.add(0, i);
        }
        end = System.currentTimeMillis();
        System.out.format("LinkedList 前部插入：%dms\n", end - start);*/

        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());


    }
}
