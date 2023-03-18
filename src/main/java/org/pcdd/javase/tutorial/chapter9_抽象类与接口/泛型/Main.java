package org.pcdd.javase.tutorial.chapter9_抽象类与接口.泛型;

class Message<T> {
    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}

public class Main {
    public static void fun(Message<?> temp) {
        System.out.println(temp.getContent());
    }


    public static void main(String[] args) {
        Message<String> msg = new Message();
        msg.setContent("pcdd.work");
        fun(msg);
    }

}

