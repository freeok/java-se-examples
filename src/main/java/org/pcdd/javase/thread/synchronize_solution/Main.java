package org.pcdd.javase.thread.synchronize_solution;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * 主线程等待子线程的多种方法（实现线程同步的多种方法）
 *
 * @author pcdd
 */
@Slf4j
public class Main {

    public static void main(String[] args) throws Exception {
        method11();
    }

    /**
     * Thread sleep()
     */
    private static void method01() throws Exception {
        long timeout1 = 1000;
        long timeout2 = timeout1 + 500;
        new Thread(() -> {
            try {
                Thread.sleep(timeout1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        // 满足 timeout2 > timeout1 即可
        Thread.sleep(timeout2);
        log.info("主线程执行！\ndo something...");
    }

    /**
     * Thread join()
     */
    private static void method02() throws Exception {
        CopyOnWriteArrayList<Thread> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                try {
                    // 随机生成睡眠时间
                    long timeout = new Random().nextLong(1000, 3000);
                    TimeUnit.MILLISECONDS.sleep(timeout);
                    System.out.printf("%s 子线程执行完毕！耗时：%sms\n", Thread.currentThread().getName(), timeout);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            list.add(thread);
            thread.start();
        }

        for (Thread thread : list) {
            thread.join();
        }

        log.info("主线程执行！\ndo something...");
    }

    /**
     * synchronized 等待唤醒机制
     */
    private static void method03() throws Exception {
        Object lock = new Object();
        // 启动子线程
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                log.info("子线程执行完毕");
                // 获取对象锁
                synchronized (lock) {
                    // 子线程唤醒
                    lock.notify();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        synchronized (lock) {
            // 主线程等待
            lock.wait();
        }
        log.info("主线程执行！\ndo something...");
    }

    /**
     * ExecutorService isTerminated() + while 轮询判断
     */
    private static void method04() throws Exception {
        int n = 3;
        String[] tasks = {"发送短信消息完毕", "发送微信消息完毕", "发送邮箱消息完毕"};
        int[] executeTimes = new int[]{2, 5, 1};
        ExecutorService threadPool = Executors.newFixedThreadPool(n);
        long start = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            int finalI = i;
            threadPool.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(executeTimes[finalI]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info(tasks[finalI]);
            });
        }

        threadPool.shutdown();
        // 关键代码
        while (true) {
            if (threadPool.isTerminated()) {
                break;
            } else {
                // 每隔1s判断一次
                TimeUnit.SECONDS.sleep(1);
            }
        }
        log.info("所有消息都发送完毕了，执行主线程任务。\n耗时ms：" + (System.currentTimeMillis() - start));
    }

    /**
     * ExecutorService awaitTermination()
     */
    private static void method05() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                long timeout = new Random().nextLong(1000, 3000);
                try {
                    TimeUnit.MILLISECONDS.sleep(timeout);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.printf("%s 子线程执行完毕！耗时：%sms\n", Thread.currentThread().getName(), timeout);
            });
        }

        executorService.shutdown();
        // 阻塞当前线程，直到所有已提交的任务完成执行，或者发生超时，或者当前线程中断，以先发生者为准。
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        log.info("主线程执行！\ndo something...");
    }

    /**
     * Future
     */
    private static void method06() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<String> future = executorService.submit(() -> {
            try {
                log.info("do something...");
                TimeUnit.SECONDS.sleep(1);
                log.info("子线程任务完成");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "子线程返回的结果";
        });

        log.info(future.get());
        executorService.shutdown();
        log.info("主线程执行！");
    }

    /**
     * CountDownLatch（计数器锁）
     */
    private static void method07() throws Exception {
        int n = 3;
        String[] tasks = {"发短信完毕", "发微信完毕", "发QQ完毕"};
        int[] executeTimes = new int[]{2, 5, 1};
        CountDownLatch countDownLatch = new CountDownLatch(n);
        ExecutorService executorService = Executors.newFixedThreadPool(n);

        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(executeTimes[finalI]);
                    log.info(tasks[finalI]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        log.info("所有消息都发送完毕了，执行主线程任务。\n耗时ms：" + (System.currentTimeMillis() - start));
        // 不要忘记关闭线程池，不然会导致主线程阻塞无法退出
        executorService.shutdown();
    }

    /**
     * CyclicBarrier（循环屏障）
     */
    private static void method08() throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(6);

        // 最后一个达到屏障的线程留给主线程，因此循环5次
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                long timeout = new Random().nextLong(1000, 3000);
                try {
                    TimeUnit.MILLISECONDS.sleep(timeout);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.printf("%s 子线程执行完毕！耗时：%sms\n", Thread.currentThread().getName(), timeout);
                // 到达屏障
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        cyclicBarrier.await();
        log.info("主线程执行！\ndo something...");
    }

    /**
     * BlockingQueue
     */
    private static void method09() throws Exception {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                queue.put("OK");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        log.info(queue.take());
        log.info("主线程执行！\ndo something...");
    }

    /**
     * CompletableFuture（本质还是Future的get方法）
     */
    private static void method10() throws Exception {
        CompletableFuture<Void> cf1 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                log.info("cf1 任务完成");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                log.info("cf2 任务完成");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<Void> cf3 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(0);
                log.info("cf3 任务完成");
                // int n = 1 / 0;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<Void> allOf = CompletableFuture.allOf(cf1, cf2, cf3);

        // 若子任务都未发生异常则返回null，否则返回异常。此步会阻塞主线程
        log.info("{}", allOf.get());
        log.info("主线程执行！");
    }

    /**
     * LockSupport
     */
    private static void method11() throws Exception {
        Thread mainThread = Thread.currentThread();

        new Thread(() -> {
            try {
                log.info("子线程开始执行");
                // 模拟子线程执行任务
                TimeUnit.SECONDS.sleep(2);
                log.info("子线程执行完毕！");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 如果线程在 park 上被阻塞，那么它将解除阻塞
            LockSupport.unpark(mainThread);
        }).start();

        // 禁用当前线程（主线程）
        LockSupport.park();
        log.info("主线程执行！\ndo something...");
    }

}
