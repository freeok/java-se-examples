package org.pcdd.javase.tutorial.chapter7_字符串;

public class StringEx02 {
    public static void main(String[] args) {
        // String s = "";
        StringBuilder sb = new StringBuilder("");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
    }
}
