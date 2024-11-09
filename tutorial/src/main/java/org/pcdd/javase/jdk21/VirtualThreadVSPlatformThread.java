package org.pcdd.javase.jdk21;

import cn.hutool.core.lang.Console;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 虚拟线程
 * 优点：占用资源低（内存、CPU）、不需要池化
 * 区别：计算密集型场景差别不大，IO 密集型场景有明显改善
 *
 * @author pcdd
 */
public class VirtualThreadVSPlatformThread {

    private record Worker(int number) implements Callable<Boolean> {
        @Override
        public Boolean call() {
            System.out.printf("线程:%s - 任务:%d sleep...%n", Thread.currentThread().getName(), number);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.printf("线程:%s - 任务:%d canceled...%n", Thread.currentThread().getName(), number);
                return false;
            }
            System.out.printf("线程:%s - 任务:%d finished....%n", Thread.currentThread().getName(), number);
            return true;
        }
    }

    /**
     * jconsole 对比
     * 创建 2000 个线程
     * 使用平台线程时：线程峰值 36   CPU 峰值 0.1% 内存初始占用 13.6 MB
     * 使用虚拟线程时：线程峰值 2008 CPU 峰值 0.1% 内存初始占用 45.2 MB
     */
    @SneakyThrows
    public static void main(String[] args) {
        int N = 50_000;
        System.out.println("开始执行任务");

        // ExecutorService executor = Executors.newFixedThreadPool(N);
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        List<Worker> tasks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tasks.add(new Worker(i));
        }

        long start = System.currentTimeMillis();
        List<Future<Boolean>> futures = executor.invokeAll(tasks);
        long successCount = 0;

        for (Future<Boolean> future : futures) {
            if (future.get()) {
                successCount++;
            }
        }

        long end = System.currentTimeMillis();
        Console.log("总共耗时: {} ms，成功数量：{}", end - start, successCount);
        executor.shutdown();
        executor.close();
    }

}
