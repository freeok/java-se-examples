package org.pcdd.javase.chapter6_数组;

import java.util.Scanner;

class ArrayUtil {
    private int[] array;
    private int N;

    public ArrayUtil() {
        initArray();
    }

    // 初始化数组
    public void initArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        this.N = sc.nextInt();
        this.array = new int[N];

        System.out.println("请为数组赋值：");
        for (int i = 0; i < this.array.length; i++) {
            array[i] = sc.nextInt();
        }
    }

    // 冒泡排序
    public void sortArray() {
        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < this.array.length - i - 1; j++) {
                if (this.array[j] > this.array[j + 1]) {
                    int temp = this.array[j];
                    this.array[j] = this.array[j + 1];
                    this.array[j + 1] = temp;
                }
            }
        }
    }

    // 数组反序
    public void reverseArray() {
        int center = this.array.length / 2;
        int head = 0, tail = this.array.length - 1;

        for (int i = 0; i < center; i++) {
            int temp = this.array[head];
            this.array[head] = this.array[tail];
            this.array[tail] = temp;
            head++;
            tail--;
        }
    }

    // 打印数组
    public void printArray() {
        for (int temp : this.array) {
            System.out.print(temp + " ");
        }
    }

}

public class book6_6 {
    public static void main(String[] args) {
        ArrayUtil obj = new ArrayUtil();
        System.out.println("排序前：");
        obj.printArray();

        System.out.println("\n升序后：");
        obj.sortArray();
        obj.printArray();

        System.out.println("\n倒序结果：");
        obj.reverseArray();
        obj.printArray();
    }
}
