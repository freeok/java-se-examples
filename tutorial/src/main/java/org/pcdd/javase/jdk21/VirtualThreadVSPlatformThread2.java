package org.pcdd.javase.jdk21;

import cn.hutool.core.lang.Console;
import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadVSPlatformThread2 {
    static class Task implements Runnable {
        private final CountDownLatch countDownLatch;

        public Task(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println("before");
                System.out.println(Thread.currentThread());
                Thread.sleep(1000);
                System.out.println("after");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 对比两者的打印内容顺序、CPU内存的占用情况（虚拟线程明显占用少）
     */
    @SneakyThrows
    public static void main(String[] args) {
        // 创建 n 个线程
        int n = 10_0000;
        // 67.867 s
        // ExecutorService executor = Executors.newFixedThreadPool(n);
        // 4.512 s
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        CountDownLatch countDownLatch = new CountDownLatch(n);
        long start = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            executor.submit(new Task(countDownLatch));
        }

        countDownLatch.await();
        Console.log("总耗时：{} ms", System.currentTimeMillis() - start);
        executor.shutdown();
        executor.close();
    }
}
