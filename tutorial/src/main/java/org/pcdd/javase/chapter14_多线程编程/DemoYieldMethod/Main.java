package org.pcdd.javase.chapter14_多线程编程.DemoYieldMethod;

/**
 * 线程礼让
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                if (i % 3 == 0) {
                    // 线程礼让
                    Thread.yield();
                    System.out.println("【YIELD】线程礼让," + Thread.currentThread().getName());
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "执行、 i = " + i);
            }
        }, "玩耍的线程");

        thread.start();

        // 主线程执行
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(10);
                System.out.println("【霸道的main线程】number = " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
