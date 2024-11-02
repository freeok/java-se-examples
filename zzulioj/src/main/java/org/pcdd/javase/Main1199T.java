package org.pcdd.javase;

import java.util.Scanner;

/**
 * http://acm.zzuli.edu.cn/showsource.php?id=8556349
 * GPT 答案正确
 */
public class Main1199T {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < T; t++) {
            StringBuilder correctOutput = new StringBuilder();
            StringBuilder userOutput = new StringBuilder();

            // 读取正确输出
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("START")) {
                    continue;
                } else if (line.equals("END")) {
                    break;
                }
                correctOutput.append(line).append("\n");
            }

            // 读取用户输出
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("START")) {
                    continue;
                } else if (line.equals("END")) {
                    break;
                }
                userOutput.append(line).append("\n");
            }

            // 比较输出
            String correctStr = correctOutput.toString();
            String userStr = userOutput.toString();

            if (correctStr.equals(userStr)) {
                System.out.println("Accepted");
            } else {
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