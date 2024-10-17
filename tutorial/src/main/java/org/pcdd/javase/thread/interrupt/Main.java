package org.pcdd.javase.thread.interrupt;

/**
 * @author pcdd
 * date 2021/5/4 19:25
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            while (true) {
                for (int i = 1; i <= 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "吃包子，第" + i + "个");
                }
                try {
                    System.out.println("吃饱了，开始休息~~~");
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "被 interrupt 了");
                }
            }

        };

        Thread thread01 = new Thread(runnable);
        thread01.setName("老韩");
        thread01.setPriority(Thread.MIN_PRIORITY);
        thread01.start();

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }

        System.out.println(thread01.getPriority());

        thread01.interrupt();
    }
}
