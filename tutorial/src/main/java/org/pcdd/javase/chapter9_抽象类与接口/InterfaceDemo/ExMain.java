package org.pcdd.javase.chapter9_抽象类与接口.InterfaceDemo;

interface IMessage1 {
    public String INFO1 = "信息1";

    public void getInfo();

}

class Computer {
    private String type;
    private double price;

    public Computer(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class MessageImpl extends Computer implements IMessage1 {


    public MessageImpl(String type, double price) {
        super(type, price);
    }

    @Override
    public void getInfo() {
        System.out.println("电脑型号：" + this.getType() + "\t电脑价格：" + this.getPrice());
        System.out.println("得到一个信息！内容：" + INFO1);
    }

    // 扩充方法
    public void ziMethod() {
        System.out.println("子类扩充方法调用！");
    }
}

public class ExMain /*extends Object*/ {
    public static void main(String[] args) {
        IMessage1 obj = new MessageImpl("华为magicbook pro", 4599.0);// 向上转型
        obj.getInfo();

        // true，说明obj是接口，父类，子类（实现类）三者的的对象
        System.out.println(obj instanceof IMessage && obj instanceof Computer && obj instanceof MessageImpl);
        System.out.println("===========================================");
        MessageImpl obj2 = (MessageImpl) obj;// 向下转型;
        obj2.ziMethod();
    }
}
