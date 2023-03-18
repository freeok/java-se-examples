package org.pcdd.javase.tutorial.chapter8_继承;

public class Test {
    public static void main(String[] args) {
        Emp one = new Emp("职员1");
    }
}

class Human {
    public Human(String name) {
        System.out.println("父类构造调用！" + name);
    }
}

class Emp extends Human {
    private String name;

    public Emp(String name) {
        super(name);
        System.out.println("子类构造调用！");
    }
}
