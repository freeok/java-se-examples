package org.pcdd.javase.tutorial.chapter12_内部类.外部类访问内部类私有成员;

/**
 * 内部类与外部类之间可以直接进行私有成员的访问
 * 一个类可以直接访问另一个类的私有成员吗？
 * 内部类可以，普通类就需要getter
 */
class Outer {
    private String info1 = "外部类属性";

    public void fun() {
        // 外部类访问内部类私有属性 : new 内部类().属性名
        System.out.println(new Inner().info2);
    }

    class Inner {
        private String info2 = "内部类属性";

        public void fun() {
            // 内部类访问外部类私有属性 : 外部类.this.属性名
            System.out.println(this.info2);
        }
    }

}

public class Main {
    public static void main(String[] args) {
        // 直接调用成员内部类
        Outer.Inner inner = new Outer().new Inner();
        inner.fun();

        // 间接调用成员内部类
        Outer outer = new Outer();
        outer.fun();

    }
}
