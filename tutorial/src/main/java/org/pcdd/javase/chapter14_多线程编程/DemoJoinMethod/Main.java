package org.pcdd.javase.chapter14_多线程编程.DemoJoinMethod;

/**
 * 线程强制执行
 * public final void join() throws InterruptedException
 */
public class Main {
    public static void main(String[] args) {
        // 获得主线程
        Thread mainThread = Thread.currentThread();

        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                if (i == 4) {
                    try {
                        // 强制执行主线程
                        mainThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + "执行、i = " + i);
            }
        }, "玩耍的线程");

        thread.start();

        // 主线程
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(100);
                System.out.println("【霸道的main线程】number = " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
