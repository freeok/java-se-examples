package org.pcdd.javase.chapter7_字符串;

public class book7_1 {

    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = "abc";
        String str3 = "ABC";
        String str4 = " Hel loWor ld ";
        String str5 = "aaabbbccc";

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str2.equalsIgnoreCase(str3));
        System.out.println(str2.concat(str3));
        System.out.println(str4.indexOf("World"));
        System.out.println(str4.substring(2, 5));

        String[] str = str5.split("");
        for (String temp : str) {
            System.out.println(temp);
        }
    }

}
