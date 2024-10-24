package org.pcdd.javase;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * http://acm.zzuli.edu.cn/showsource.php?id=8556367
 * 正确
 */
public class Main1242GPT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if (n == 0 && m == 0) {
                break;
            }

            Set<Integer> setA = new HashSet<>();
            Set<Integer> setB = new HashSet<>();

            for (int i = 0; i < n; i++) {
                setA.add(sc.nextInt());
            }

            for (int i = 0; i < m; i++) {
                setB.add(sc.nextInt());
            }

            Set<Integer> results = new TreeSet<>(setA);
            results.removeAll(setB); // 计算 A - B

            if (results.isEmpty()) {
                System.out.println("NULL");
            } else {
                for (int num : results) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }

}