package org.pcdd.javase.tutorial.chapter14_多线程编程.DemoThreadNameMethod;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            // 获取当前线程对象名称
            System.out.println(Thread.currentThread().getName());
        };

        // 手动设置线程名称
        new Thread(runnable, "线程A").start();
        // 自动设置线程名称
        new Thread(runnable).start();
        // 手动设置线程名称
        new Thread(runnable, "线程B").start();
    }

}

