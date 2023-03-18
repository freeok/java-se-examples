package org.pcdd.javase.tutorial.chapter9_抽象类与接口.InterfaceDemo;

interface IMessage {
    public void send();

    default void show() {
        System.out.println(this.getClass().getName().substring(14, 17) + "显示信息");
    }
}

abstract class Fu implements IMessage {
    @Override
    public void send() {
        System.out.println(this.getClass().getName().substring(14, 17) + "发信息...");
    }
}

class Zi1 extends Fu {

}

class Zi2 extends Fu {

}

public class DemoDefaultMethod {
    public static void main(String[] args) {

        IMessage one = new Zi1();
        IMessage two = new Zi2();

        one.send();
        one.show();

        two.send();
        two.show();

    }
}
