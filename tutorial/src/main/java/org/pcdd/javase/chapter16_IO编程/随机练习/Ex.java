package org.pcdd.javase.chapter16_IO编程.随机练习;

import java.io.IOException;
import java.util.Scanner;

// 使用 BufferedReader 在控制台读取字符
public class Ex {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str;
        while (!sc.hasNext("end")) {
            str = sc.nextLine();
            System.out.println(str);
        }
    }
}
