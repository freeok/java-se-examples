package org.pcdd.javase.tutorial.chapter14_多线程编程;

/**
 * @author pcdd
 * date 2021/3/16 22:48
 */
class Message {
    private String title;
    private String content;

    public synchronized void set(String title, String content) {
        this.title = title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = content;
    }

    public synchronized String get() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.title + "---" + this.content;
    }
}

class Producer implements Runnable {

    private Message message;

    public Producer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {

            if (i % 2 == 0) {
                this.message.set("pc", "student or coder");
            } else {
                this.message.set("pcdd", "welcome to pcdd!");
            }

        }
    }
}

class Consumer implements Runnable {
    private Message message;

    public Consumer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.message.get());
        }
    }
}

/**
 * @author pcdd
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {

        Message message = new Message();
        new Thread(new Producer(message)).start();
        new Thread(new Consumer(message)).start();

    }

}
