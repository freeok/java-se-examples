package org.pcdd.javase.chapter14_多线程编程.DemoSynchronized;

/**
 * 互斥锁。注意事项和细节
 * 1.同步方法如果没有使用 static 修饰:默认锁对象为 this
 * 2.如果方法使用 static 修饰,默认锁对象:当前类.class
 * 3.实现的落地步骤:
 * 需要先分析上锁的代码
 * 选择同步代码块或同步方法
 * 要求多个线程的锁对象为同一个即可!
 */
class MyThread implements Runnable {

    private int ticket = 100;

    // 非静态的同步方法
    @Override
    public synchronized void run() {
        while (true) {
            if (this.ticket > 0) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖票，ticket = " + this.ticket--);

            } else {
                System.out.println(Thread.currentThread().getName() + ":票已经卖光了");
                break;
            }
        }
    }

    /*@Override
    public void run() {
        while (true) {
            // 同步代码块
            synchronized (this) {
                if (this.ticket > 0) {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票，ticket = " + this.ticket--);
                } else {
                    System.out.println(Thread.currentThread().getName() + ":票已经卖光了");
                    break;
                }
            }
        }
    }*/
}

public class Main {
    public static void main(String[] args) {
        Runnable mt = new MyThread();

        new Thread(mt, "售票员A").start();
        new Thread(mt, "售票员B").start();
        new Thread(mt, "售票员C").start();
    }
}
