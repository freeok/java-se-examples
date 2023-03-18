package org.pcdd.javase.tutorial.chapter16_IO编程.BufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author pcdd
 * date 2020/10/11 23:57
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = input.readLine();
            System.out.println(s);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
