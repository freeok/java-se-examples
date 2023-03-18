package org.pcdd.javase.tutorial.chapter7_字符串;

public class StringMethod {
    /**
     * String常用方法
     * 查找：indexOf,lastIndexOf,startsWith,endsWith
     * 比较：compareTo,compareIgnoreCase
     * 替换：replace,replaceAll,replaceFirst
     * 截取：substring
     * 拆分：split
     */
    public static void main(String[] args) {
        String str = "www.sqnu.edu.cn";
        String ss = "www.haue.edu.cn";
        // 查找
        System.out.println(str.indexOf("sqnu"));
        System.out.println(str.lastIndexOf("w"));
        System.out.println(str.startsWith("www"));
        System.out.println(str.endsWith("cn"));
        // 比较
        System.out.println(str.compareTo(ss));
        System.out.println(str.compareToIgnoreCase(ss));
        // 替换
        System.out.println(str.replace(".", "@"));
        System.out.println(str.replaceAll("w", "+"));
        System.out.println(str.replaceFirst(".", "@"));
        // 截取
        System.out.println(ss.substring(4));
        System.out.println(ss.substring(4, 8));
        // 拆分
        for (int i = 0; i < str.split(".").length; i++) {
            System.out.print(str.split(".")[i]);
        }

    }
}
