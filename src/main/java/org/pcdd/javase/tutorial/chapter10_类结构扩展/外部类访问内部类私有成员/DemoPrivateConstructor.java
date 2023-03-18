package org.pcdd.javase.tutorial.chapter10_类结构扩展.外部类访问内部类私有成员;

/* 构造方法私有化
 * 单例设计模式：饿汉式、懒汉式
 * 多例设计模式
 * */

interface ISingleton {
    public void print();
}

// 饿汉式
class Singleton1 implements ISingleton {
    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

    @Override
    public void print() {
        System.out.println("饿汉式");
    }
}


// 懒汉式
class Singleton2 implements ISingleton {
    private static Singleton2 instance;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

    @Override
    public void print() {
        System.out.println("懒汉式");
    }
}

public class DemoPrivateConstructor {
    public static void main(String[] args) {
        // 饿汉式
        ISingleton one = Singleton1.getInstance();
        one.print();

        // 懒汉式
        ISingleton two = Singleton2.getInstance();
        two.print();
    }
}
