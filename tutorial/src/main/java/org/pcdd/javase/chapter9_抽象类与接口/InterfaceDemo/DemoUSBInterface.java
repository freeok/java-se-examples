package org.pcdd.javase.chapter9_抽象类与接口.InterfaceDemo;

interface IUSB {
    public void work();

    public default void close() {
        System.out.println("关闭设备！");
    }
}

class Keyboard implements IUSB {
    @Override
    public void work() {
        System.out.println("键盘敲击");
    }

}

class Mouse implements IUSB {
    @Override
    public void work() {
        System.out.println("鼠标点击");
    }
}

class Laptop {
    public void use(IUSB usb) {
        usb.work();
        usb.close();
    }
}

public class DemoUSBInterface {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.use(new Mouse());
        laptop.use(new Keyboard());
    }
}
