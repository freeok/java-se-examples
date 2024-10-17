package org.pcdd.javase.chapter17_反射机制.反射机制工厂设计模式;

interface IMessage {
    public void send();
}

class CloudMessage implements IMessage {
    @Override
    public void send() {
        System.out.println("云消息");
    }
}

class NetMessage implements IMessage {
    @Override
    public void send() {
        System.out.println("网络消息");
    }
}

class Factory {
    private Factory() {
    }

    public static <T> T getInstance(String className, Class<T> clazz) {
        T instance = null;
        try {
            instance = (T) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return instance;
    }
}

public class Main {
    public static void main(String[] args) {
        IMessage message = Factory.getInstance("反射机制工厂设计模式.CloudMessage", IMessage.class);
        message.send();

    }
}
