package org.pcdd.javase.jdk21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * JDK 21 新特性：虚拟线程
 *
 * @author pcdd
 */
public class VirtualThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        func1_1();
        // func1_2();
        // func2();
        // func3();
    }

    /**
     * 创建方式 1.1
     */
    private static void func1_1() {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 2000; i++) {
            Thread.startVirtualThread(runnable).setName("thread-" + i);
        }
    }

    /**
     * 创建方式 1.2
     */
    private static void func1_2() {
        Runnable runnable = () -> System.out.println("Hello, World!");

        Thread.ofVirtual()
                .name("pcdd-virtual-thread")
                .start(runnable);
    }

    /**
     * 创建方式 2
     */
    private static void func2() {
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 100; i++) {
                executorService.execute(() -> System.out.println("Hello, World!"));
            }
        }
    }

    /**
     * 创建方式 3
     */
    private static void func3() {
        Runnable runnable = () -> System.out.println("Hello, World!");

        ThreadFactory virtualThreadFactory = Thread.ofVirtual()
                .name("pcdd", 0)
                .factory();

        Thread factoryThread = virtualThreadFactory.newThread(runnable);
        factoryThread.start();
    }

}
