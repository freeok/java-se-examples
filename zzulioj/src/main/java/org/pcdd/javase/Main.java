package org.pcdd.javase;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String line = sc.nextLine();
            // 十进制
            if (line.contains(".")) {
                StringBuilder binaryIp = new StringBuilder();
                for (String s : line.split("\\.")) {
                    String binaryString = Integer.toBinaryString(Integer.parseInt(s));
                    binaryIp.append(String.format("%08d", Integer.parseInt(binaryString)));
                }
                System.out.println(binaryIp);
            } else {
                StringBuilder decimalIp = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    decimalIp.append(Integer.parseInt(line.substring(i * 8, (i + 1) * 8), 2));
                    if (i < 3) decimalIp.append(".");
                }
                System.out.println(decimalIp);
            }
        }
    }

}