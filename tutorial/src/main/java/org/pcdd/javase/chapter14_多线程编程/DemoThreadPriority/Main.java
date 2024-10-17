package org.pcdd.javase.chapter14_多线程编程.DemoThreadPriority;

/**
 * 设置线程优先级 public final void setPriority(int newPriority)
 * 获取线程优先级 public final int getPriority()
 */
public class Main {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "执行。 i = " + i);
            }
        };

        Thread thread1 = new Thread(runnable, "线程对象A");
        Thread thread2 = new Thread(runnable, "线程对象B");
        Thread thread3 = new Thread(runnable, "线程对象C");

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("main线程的优先级：" + Thread.currentThread().getPriority());
    }
}
