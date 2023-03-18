package org.pcdd.javase.tutorial.chapter15_常用类库.定时任务;


import java.util.Timer;
import java.util.TimerTask;

/**
 * @author pcdd
 * 2020/10/12 20:25
 */
class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("哈喽呀，童鞋。");
    }
}

public class Main {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTask(), 0, 10000);
    }

}
