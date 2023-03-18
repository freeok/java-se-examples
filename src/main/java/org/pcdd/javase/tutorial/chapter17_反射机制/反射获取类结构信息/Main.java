package org.pcdd.javase.tutorial.chapter17_反射机制.反射获取类结构信息;

interface IMessageService {
}

interface IChannelService extends IMessageService {
}

abstract class AbstractClass {
}

class Mail extends AbstractClass implements IMessageService, IChannelService {
}

public class Main {
    public static void main(String[] args) {
        Class<?> cls = Mail.class;
        System.out.println("包信息：" + cls.getPackage().getName());
        System.out.println("继承的父类:" + cls.getSuperclass().getName());
        for (Class<?> temp : cls.getInterfaces()) {
            System.out.println("实现的接口：" + temp.getName());
        }

    }
}
