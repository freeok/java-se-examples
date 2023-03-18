package org.pcdd.javase.tutorial.chapter9_抽象类与接口.InterfaceDemo;

// 工厂代理设计模式示例

interface IEat {
    public void get();
}

class EatReal implements IEat {
    @Override
    public void get() {// 核心实现
        System.out.println("真实主题：吃饭");
    }
}

class EatProxy implements IEat {
    private IEat eat;

    public EatProxy(IEat eat) {
        this.eat = eat;
    }

    @Override
    public void get() {// 代理实现
        this.prepare();
        this.eat.get();// 真实主题
        this.clear();
    }

    public void prepare() {
        System.out.println("代理主题：买菜");
        System.out.println("代理主题：洗菜");
        System.out.println("代理主题：做饭");
    }

    public void clear() {
        System.out.println("代理主题：洗碗");
    }

}

class FactoryEat {
    public static IEat getInstance() {
        return new EatProxy(new EatReal());
    }
}

public class DemoProxy {
    public static void main(String[] args) {
        IEat eat = FactoryEat.getInstance();
        eat.get();
    }
}
