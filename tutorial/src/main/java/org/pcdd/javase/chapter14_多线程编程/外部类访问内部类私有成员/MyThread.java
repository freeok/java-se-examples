package org.pcdd.javase.chapter14_多线程编程.外部类访问内部类私有成员;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Java多线程3种实现方式：继承Thread类，实现Runnable接口或Callable接口

class Test {
    public static void main(String[] args) {
        Callable<String> call = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " i = " + i);
            }
            return "success";
        };

        FutureTask<String> task = new FutureTask<>(call);

        // 启动线程
        new Thread(task, "线程").start();

        try {
            System.out.println("执行结果：" + task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
