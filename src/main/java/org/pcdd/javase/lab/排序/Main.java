package org.pcdd.javase.lab.排序;

import java.util.Random;

public class Main {
    public static int[] a;

    static void init(int len) {
        Random r = new Random();
        a = new int[len];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt();
        }
    }

    /**
     * 冒泡排序
     */
    static void fun1(int[] a) {
        long s = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        long e = System.currentTimeMillis();
        System.out.println("冒泡耗时：" + (e - s) + "ms");
    }

    /**
     * 选择排序
     */
    static void fun2(int[] a) {
        long s = System.currentTimeMillis();
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            // 查找最小元素的下标
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
        long e = System.currentTimeMillis();
        System.out.println("选择耗时：" + (e - s) + "ms");
    }

    static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("初始化数组：");
        init(10000);
        print(a);

        fun1(a);
        System.out.println("冒泡排序");
        print(a);

        fun2(a);
        System.out.println("选择排序");
        print(a);

    }
}
