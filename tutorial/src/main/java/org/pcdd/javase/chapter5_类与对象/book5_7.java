package org.pcdd.javase.chapter5_类与对象;

/***
 * 构造代码块，静态代码块
 * 优先级：静态代码块>构造代码块>构造方法
 * JDK1.7之前可以使用静态代码块代替主方法，该bug已修复
 */
public class book5_7 {
    static {
        // 主类的静态代码块
        System.out.println("静态代码块执行！");
    }

    public static void main(String[] args) {
        new Foo();
    }
}

class Foo {
    {
        System.out.println("构造代码块执行！");
    }

    public Foo() {
        System.out.println("构造方法执行！");
    }
}

