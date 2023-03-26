package org.pcdd.javase.thread.volatile_keyword;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    private static int a = 0;
    // private static volatile int a = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            // 不用volatile的解决方法：循环体中调用Thread.onSpinWait()：while (a == 0) Thread.onSpinWait();
            while (a == 0) ;
            log.info("线程结束！a = {}", a);
        }).start();

        Thread.sleep(1000);
        log.info("正在修改a的值...");
        // 很明显，按照我们的逻辑来说，a的值被修改那么另一个线程将不再循环，解决方法：添加volatile关键字
        a = 1;
    }

}