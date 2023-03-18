package org.pcdd.javase.tutorial.chapter14_多线程编程.DemoInterruptedMethod;

/**
 * 线程终端操作
 * public boolean isInterrupted() 判断线程是否被中断
 * public void interrupt() 中断线程执行
 */
public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("【BEFORE】准备睡10秒，不要打扰我！");
            try {
                Thread.sleep(10000);
                System.out.println("【FINISH】睡醒了，开始工作和学习生活！");
            } catch (InterruptedException e) {
                System.out.println("【EXCEPTION】睡觉被打扰了，坏脾气像火山爆发般袭来！");
            }

        });

        thread.start();
        try {
            // 保证子线程先运行1秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 如果线程未被中断，就中断线程
        if (!thread.isInterrupted()) {
            System.out.println("【INTERRUPT】敲锣打鼓欢天喜地地路过你睡觉的地方！");
            thread.interrupt();
        }


    }
}
