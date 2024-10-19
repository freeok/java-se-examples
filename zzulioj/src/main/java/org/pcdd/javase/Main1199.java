package org.pcdd.javase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * http://acm.zzuli.edu.cn/showsource.php?id=8521672
 */
public class Main1199 {

    static int total;
    static final Scanner sc = new Scanner(System.in);
    public static final String START = "START";
    public static final String END = "END";

    public static void main(String[] args) {
        // 答案数
        total = sc.nextInt();
        // 分别为：正确答案、提交的答案
        List<List<String>> lists = extractAnswer();
        judgment(lists.get(0), lists.get(1));
    }

    static void judgment(List<String> correctAnswers, List<String> yourAnswers) {
        for (int i = 0; i < total; i++) {
            String s1 = correctAnswers.get(i);
            String s2 = yourAnswers.get(i);

            // System.out.println(s1 + " | " + s2);

            if (Objects.equals(s1, s2)) {
                System.out.println("Accepted");

            } else if (Objects.equals(s1.replaceAll("\\s", ""), s2.replaceAll("\\s", ""))) {
                System.out.println("Presentation Error");

            } else {
                System.out.println("Wrong Answer");
            }
        }
    }

    static List<List<String>> extractAnswer() {
        // 正确答案
        List<String> correctAnswers = new ArrayList<>();
        // 提交的答案
        List<String> yourAnswers = new ArrayList<>();
        List<List<String>> answers = new ArrayList<>();

        StringBuilder input = new StringBuilder();

        for (int i = 1; i <= total * 2; i++) {
            // 读取输入，直到用户输入"END"
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                input.append(line);
                if (line.equals("END")) {
                    break;
                }
            }
            String s = input.toString();
            if (s.startsWith(START) && s.endsWith(END)) {
                int startIndex = s.indexOf(START) + START.length();
                int endIndex = s.lastIndexOf(END);
                // 截取 START 和 END 之间数据部分
                String result = s.substring(startIndex, endIndex);
                if (i % 2 != 0) {
                    correctAnswers.add(result);
                } else {
                    yourAnswers.add(result);
                }
            }
            input.setLength(0);
        }

        answers.add(correctAnswers);
        answers.add(yourAnswers);

        return answers;
    }

}