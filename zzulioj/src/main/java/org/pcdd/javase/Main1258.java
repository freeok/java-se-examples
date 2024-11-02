package org.pcdd.javase;

import java.util.Scanner;

/**
 * http://acm.zzuli.edu.cn/problem.php?id=1258
 */
public class Main1258 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            char inner = sc.next().charAt(0);
            char outer = sc.next().charAt(0);
            char[][] basket = new char[n][n];

            // 填充筐的字符，从外圈到内圈
            for (int x = 0; x <= n / 2; x++) {
                // 从外圈到内圈，偶数圈为 a，奇数圈为 b
                char c = (n / 2 - x) % 2 == 0 ? inner : outer;

                for (int y = x; y < n - x; y++) {
                    basket[x][y] = c; // 上边
                    basket[n - x - 1][y] = c; // 下边
                    basket[y][x] = c; // 左边
                    basket[y][n - x - 1] = c; // 右边
                }
            }

            if (n != 1)
                basket[0][0] = basket[0][n - 1] = basket[n - 1][0] = basket[n - 1][n - 1] = ' ';

            for (char[] chars : basket)
                System.out.println(new String(chars));
            System.out.println();
        }
    }
}

