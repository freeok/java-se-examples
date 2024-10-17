package org.pcdd.javase.thread.state;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pcdd
 * @see Thread.State
 * date 2021/5/4 23:23
 */
@Slf4j
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                for (int i = 0; i < 10; i++) {
                    log.info("say hello " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
        });
        log.info(thread.getName() + " 状态 " + thread.getState());
        thread.start();

        while (Thread.State.TERMINATED != thread.getState()) {
            log.info(thread.getName() + " 状态 " + thread.getState());
            Thread.sleep(500);
        }

        log.info(thread.getName() + " 状态 " + thread.getState());
    }

}
