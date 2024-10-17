package org.pcdd.javase.chapter14_多线程编程.DemoSleepMethod;

/**
 * public static void sleep(long millis) throws InterruptedException 设置睡眠毫秒值
 * public static void sleep(long millis, int nanos) throws InterruptedException 设置睡眠毫秒值和纳秒值
 */
public class Main {
    public static void main(String[] args) {
        Runnable run = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "、i = " + i);
                try {
                    // 暂停1秒执行
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 启动3个线程
        for (int i = 0; i < 3; i++) {
            new Thread(run, "线程对象-" + i).start();
        }


    }
}
