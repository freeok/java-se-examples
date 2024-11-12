package org.pcdd.javase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * 答案错误：http://acm.zzuli.edu.cn/showsource.php?id=8521672
 * 改正后正确
 */
public class Main1199T2 {

    static int n;
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 答案数
        n = Integer.parseInt(sc.nextLine());
        List<List<String>> lists = extractAnswer();
        // 分别为：正确答案、提交的答案
        judgment(lists.get(0), lists.get(1));
    }

    static List<List<String>> extractAnswer() {
        List<String> correctAnswers = new ArrayList<>();
        List<String> yourAnswers = new ArrayList<>();
        List<List<String>> answers = new ArrayList<>();
        // 4组，每组2个
        for (int i = 1; i <= n * 2; i++) {
            StringBuilder sb = new StringBuilder();
            // 读取输入，直到用户输入"END"
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                sb.append(line);
                if (line.equals("END")) break;
                sb.append("\n");
            }
            // 原提交错误原因在这，没加.trim()
            String s = sb.toString().trim();
            // 截取 START 和 END 之间的数据部分
            String result = s.substring(s.indexOf("START") + "START".length(), s.lastIndexOf("END"));
            if (i % 2 != 0) {
                correctAnswers.add(result);
            } else {
                yourAnswers.add(result);
            }
        }

        answers.add(correctAnswers);
        answers.add(yourAnswers);

        return answers;
    }

    static void judgment(List<String> correctAnswers, List<String> yourAnswers) {
        for (int i = 0; i < n; i++) {
            String s1 = correctAnswers.get(i);
            String s2 = yourAnswers.get(i);
            if (Objects.equals(s1, s2)) {
                System.out.println("Accepted");
            } else if (Objects.equals(s1.replaceAll("\\s+", ""), s2.replaceAll("\\s+", ""))) {
                System.out.println("Presentation Error");
            } else {
                System.out.println("Wrong Answer");
            }
        }
    }

}
