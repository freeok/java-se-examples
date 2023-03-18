package org.pcdd.javase.tutorial.chapter14_多线程编程;

/**
 * @author pcdd
 * date 2021/3/16 23:32
 */
public class DemoDaemon {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }, "用户线程");

        // 用户进程死亡，守护进程也死亡，无论守护进程是否执行完毕
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }, "守护线程");

        thread2.setDaemon(true);

        thread1.start();
        thread2.start();

    }

}
