package org.pcdd.javase.tutorial.chapter14_多线程编程.Demo02Runnable;

public class Main {
    public static void main(String[] args) {
        // lambda表达式
        Runnable run = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " i = " + i);
            }
        };

        // 启动3个线程
        for (int i = 1; i <= 3; i++) {
            new Thread(run, "线程" + i).start();
        }
    }
}
