package org.pcdd.javase.tutorial.chapter12_内部类.内部类的同名变量访问;

class Outer {
    // 外部类的成员变量
    int num = 10;

    class Inner {
        // 内部类的成员变量
        int num = 20;

        void methodInner() {
            // 内部类方法的局部变量
            int num = 30;
            // 30
            System.out.println(num);
            // 20
            System.out.println(this.num);
            // 10
            System.out.println(Outer.this.num);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new Outer().new Inner().methodInner();
    }
}
