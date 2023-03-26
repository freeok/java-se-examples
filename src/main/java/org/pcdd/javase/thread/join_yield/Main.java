package org.pcdd.javase.thread.join_yield;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pcdd
 * date 2021/5/4 22:27
 */
@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread childThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                log.info("子线程（老大） 吃第 " + i + " 个包子");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        childThread.start();

        for (int i = 1; i <= 10; i++) {
            log.info("主线程（小弟） 吃第 " + i + " 个包子");
            Thread.sleep(100);
            if (i == 5) {
                log.info("主线程（小弟）让子线程（老大）先吃 ");

                // join: 线程的插队。插队的线程一旦插队成功，则肯定先执行完插入的线程所有的任务（相当于让子线程先执行完毕）
                childThread.join();
                log.info("子线程（老大）吃完了，主线程（小弟）接着吃");
                log.info("childThread state: {}", childThread.getState());

                // yield: 线程的礼让。当前线程让出cpu，让其他线程执行，但礼让的时间不确定，所以也不一定礼让成功
                // Thread.yield();
            }
        }

    }
}
