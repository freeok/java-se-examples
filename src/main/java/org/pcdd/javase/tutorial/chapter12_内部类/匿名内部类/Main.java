package org.pcdd.javase.tutorial.chapter12_内部类.匿名内部类;

interface IMessage {
    void send(String str);

    String getContent();
}

public class Main {
    public static void main(String[] args) {
        /**
         * 某些子类只使用一次的情况下，为了减少类的定义数量，可以使用匿名内部类
         */
        IMessage message = new IMessage() {
            @Override
            public void send(String str) {
                System.out.println(str);
            }

            @Override
            public String getContent() {
                return "www.pcdd.work";
            }
        };

        message.send("pcdd.work");
        System.out.println(message.getContent());

    }
}
