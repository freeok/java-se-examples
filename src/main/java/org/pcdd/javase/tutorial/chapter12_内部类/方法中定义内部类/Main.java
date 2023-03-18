package org.pcdd.javase.tutorial.chapter12_内部类.方法中定义内部类;

/**
 * 注意：JDK1.8以前，如果方法中定义的内部类想要访问参数或局部变量，需要使用final关键字进行定义
 */
class Outer {
    private String msg = "pcdd.work";

    public void fun(long time) {
        class Inner {
            public void print() {
                System.out.println(Outer.this.msg);
                System.out.println(time);
            }
        }
        new Inner().print();
    }
}


public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.fun(System.currentTimeMillis());


    }
}
