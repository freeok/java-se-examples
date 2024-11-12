package org.pcdd.javase;

import java.util.Scanner;

/**
 * http://acm.zzuli.edu.cn/showsource.php?id=8556349
 * GPT 答案正确
 */
public class Main1199T {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            StringBuilder correctOutput = new StringBuilder();
            StringBuilder userOutput = new StringBuilder();

            // 读取正确输出
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if ("START".equals(line)) continue;
                else if ("END".equals(line)) break;
                correctOutput.append(line).append("\n");
            }

            // 读取用户输出
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if ("START".equals(line)) continue;
                else if ("END".equals(line)) break;
                userOutput.append(line).append("\n");
            }

            // 比较输出
            String correctStr = correctOutput.toString();
            String userStr = userOutput.toString();

            if (correctStr.equals(userStr)) {
                System.out.println("Accepted");
            }else {
                // 去除空白字符后比较
                String normalizedCorrect = correctStr.replaceAll("\\s+", "");
                String normalizedUser = userStr.replaceAll("\\s+", "");

                if (normalizedCorrect.equals(normalizedUser)) {
                    System.out.println("Presentation Error");
                } else {
                    System.out.println("Wrong Answer");
                }
            }
        }
    }

}