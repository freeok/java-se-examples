package org.pcdd.javase.tutorial.chapter12_内部类.使用static定义内部类;

class Outer {
    private static final String MSG = "pcdd.work";

    static class Inner {
        public void print() {
            System.out.println(Outer.MSG);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner();
        inner.print();
    }
}
