package org.pcdd.javase;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * http://acm.zzuli.edu.cn/showsource.php?id=8522127
 * C++ 通过，Java 一直不通过
 */
public class Main1178 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String s = scanner.nextLine();
            if (s.equals("#")) {
                break;
            }

            Set<String> words = new TreeSet<>();
            String[] wordArray = s.split("\\s+");

            for (String word : wordArray) {
                if (!word.matches("\\s+")) { // 确保不添加空字符串
                    words.add(word.toLowerCase());
                }
            }

            System.out.println(words.size());
        }
    }
}
