package org.pcdd.javase.game;

import java.util.Random;
import java.util.Scanner;

/**
 * 猜数字小游戏
 * 范围是1000以内的数字
 * 共有十次机会
 */
public class NumberGuessingGame {
    public static void main(String[] args) {
        System.out.println("猜数字小游戏开始！");
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int systemNumber = r.nextInt(1001);
        int youNumber = 0;

        for (int i = 9; i >= 0; i--) {
            System.out.println("请输入你猜的数：");
            youNumber = sc.nextInt();
            if (systemNumber > youNumber) {
                System.out.println("猜小了，你还有" + i + "次机会");
            } else if (systemNumber < youNumber) {
                System.out.println("猜大了，你还有" + i + "次机会");
            } else {
                System.out.println("恭喜你！猜对了！你一共消耗了" + (9 - i) + "次机会");
                System.out.println("游戏结束！");
                System.exit(-1);
            }
        }
        System.out.println("很遗憾，答案为" + systemNumber + ",游戏结束！");
    }
}
