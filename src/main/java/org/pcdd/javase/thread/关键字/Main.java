package org.pcdd.javase.thread.关键字;

public class Main {
    private static int a = 0;
    // private volatile static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (a == 0) ;
            System.out.println("线程结束！");
        }).start();

        Thread.sleep(1000);
        System.out.println("正在修改a的值...");
        // 很明显，按照我们的逻辑来说，a的值被修改那么另一个线程将不再循环，解决方法：添加volatile关键字
        a = 1;
    }
}