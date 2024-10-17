package org.pcdd.javase.chapter9_抽象类与接口.InterfaceDemo;

import java.util.Scanner;

/***
 * 工厂设计模式示例
 * 作用：解耦
 * 使用场景：获取接口对象时
 */

interface IComputer {
    public void printComputer();
}

class Lenovo implements IComputer {

    @Override
    public void printComputer() {
        System.out.println("这是一台联想电脑");
    }
}

class Apple implements IComputer {
    @Override
    public void printComputer() {
        System.out.println("这是一台苹果电脑");
    }
}

class Hp implements IComputer {
    @Override
    public void printComputer() {
        System.out.println("这是一台惠普电脑");
    }
}

class Factory {
    public static IComputer getInstance(String computerName) {
        if ("lenovo".equalsIgnoreCase(computerName)) {
            return new Lenovo();
        } else if ("apple".equalsIgnoreCase(computerName)) {
            return new Apple();
        } else if ("hp".equalsIgnoreCase(computerName)) {
            return new Hp();
        }

        return null;
    }
}

public class DemoFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你想要的电脑品牌：");
        IComputer computer = Factory.getInstance(sc.nextLine());

        if (computer != null)
            try {
                computer.printComputer();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        else {
            System.out.println("抱歉，暂无该品牌的电脑");
        }

        System.out.println("123".equalsIgnoreCase(null));

    }
}
