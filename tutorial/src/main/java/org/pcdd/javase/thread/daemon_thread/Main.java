package org.pcdd.javase.thread.daemon_thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pcdd
 * date 2021/5/4 22:55
 */
@Slf4j
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("马蓉 和 宋喆 在快乐的聊天，哈哈哈");
            }
        });

        // 如果我们希望当主线程结束后，子线程自动结束，只需将子线程设为守护线程即可
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 10; i++) {
            log.info("宝强在辛苦的工作。。" + i);
            Thread.sleep(1000);
        }
    }

}
