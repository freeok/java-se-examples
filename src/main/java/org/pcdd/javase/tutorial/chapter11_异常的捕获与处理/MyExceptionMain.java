package org.pcdd.javase.tutorial.chapter11_异常的捕获与处理;


// 自定义异常，仅需继承Exception类

import java.util.Scanner;

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

class Food {
    public static void eat(int num) throws MyException {
        if (num > 9999) {
            throw new MyException("吃的太多，撑死");
        } else {
            System.out.println("撑不死");
        }
    }
}

public class MyExceptionMain {
    public static void main(String[] args) {
        System.out.println("请输入吃米粒数量：");
        try {
            Food.eat(new Scanner(System.in).nextInt());
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
