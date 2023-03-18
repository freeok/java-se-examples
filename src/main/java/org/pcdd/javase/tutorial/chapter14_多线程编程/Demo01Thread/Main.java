package org.pcdd.javase.tutorial.chapter14_多线程编程.Demo01Thread;

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " i = " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 启动3个线程
        for (int i = 0; i < 3; i++) {
            new Thread(new MyThread(), "线程对象" + i).start();
        }
    }
}
