package org.pcdd.javase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * http://acm.zzuli.edu.cn/showsource.php?id=8569336
 * 时间超限，不能暴力，要用滑动窗口
 */
public class Main1266F {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        while (sc.hasNext()) {
            // 规定秒内
            int n = sc.nextInt();
            // 规定日志数
            int m = sc.nextInt();
            // 日志数
            int k = sc.nextInt();
            sc.nextLine();
            List<String> list = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                String s = sc.nextLine();
                list.add(s.substring(0, 19));
            }

            String result = "-1";
            for (int i = 0; i < k; i++) {
                int count = 0;

                for (int j = i + 1; j < k; j++) {
                    long between = ChronoUnit.SECONDS.between(LocalDateTime.parse(list.get(i), formatter),
                            LocalDateTime.parse(list.get(j), formatter));
                    if (between > n) break;
                    count++;
                    // System.out.println(date + " " + next + " 相差 " + between + " s");
                }
                // 已找到
                if (count >= m) {
                    // System.out.printf("%d 秒内，产生的的日志数大于等于 %d 条，为 %d%n", n, n, count);
                    result = list.get(i + m - 1);
                    break;
                }
            }

            System.out.println(result);
        }
    }

}
