package org.pcdd.javase;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * http://acm.zzuli.edu.cn/showsource.php?id=8522127
 * C++ 通过，Java 一直不通过
 */
public class Main1178 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if ("#".equals(line)) break;

            Set<String> words = new HashSet<>();

            for (String word : line.split("\\s+"))
                if (!word.isEmpty()) // 关键，要考虑输入的空串（直接回车）
                    words.add(word);

            System.out.println(words.size());
        }
    }

}