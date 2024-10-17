package org.pcdd.javase.chapter7_字符串;

import java.util.Scanner;

class ConcatString {
    private String[] str;

    public ConcatString() {
    }

    public String[] getStr() {
        return str;
    }

    public void setStr(String[] str) {
        this.str = str;
    }

    public void initArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        int n = sc.nextInt();
        this.str = new String[n];

        System.out.println("请输入数组的值：");
        for (int i = 0; i < str.length; i++) {
            str[i] = sc.next();                                             // next()和nextLine()的区别还没搞清楚
        }
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length; i++) {
            sb.append("word").append(this.str[i]).append("#");
        }
        return sb.toString();
    }

}

public class StringEx01 {
    public static void main(String[] args) {
        ConcatString obj = new ConcatString();
        obj.initArray();
        System.out.println(obj.getResult());
    }
}
