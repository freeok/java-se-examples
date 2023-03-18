package org.pcdd.javase.thread.线程插队和礼让;

/**
 * @author pcdd
 * date 2021/5/4 22:27
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 1; i <= 20; i++) {
                System.out.println("子线程（老大） 吃了 " + i + " 包子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        for (int i = 1; i <= 20; i++) {
            System.out.println("主线程（小弟） 吃了 " + i + " 包子");
            Thread.sleep(1000);
            if (i == 5) {
                System.out.println("主线程（小弟）让子线程（老大）先吃 ");

                // 这里相当于让 子线程 先执行完毕
                // join:线程的插队。插队的线程一旦插队成功，则肯定先执行完插入的线程所有的任务
                thread.join();
                System.out.println(thread.getState());

                // yield:线程的礼让。让出cpu，让其他线程执行，但礼让的时间不确定，所以也不一定礼让成功
                // Thread.yield();

                System.out.println("子线程（老大）吃完了，主线程（小弟）接着吃");
            }
        }


    }
}
