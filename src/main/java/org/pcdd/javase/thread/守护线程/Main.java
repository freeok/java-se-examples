package org.pcdd.javase.thread.守护线程;

/**
 * @author pcdd
 * date 2021/5/4 22:55
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new MyDaemonThread());

        // 如果我们希望当主线程结束后，子线程自动结束，只需将子线程设为守护线程即可
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("宝强在辛苦的工作。。" + i);
            Thread.sleep(1000);
        }


    }
}

class MyDaemonThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("马蓉 和 宋喆 在快乐的聊天，哈哈哈");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
