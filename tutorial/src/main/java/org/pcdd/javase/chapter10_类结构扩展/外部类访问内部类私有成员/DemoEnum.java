package org.pcdd.javase.chapter10_类结构扩展.外部类访问内部类私有成员;

/**
 * 枚举类的定义
 */

enum Color {
    RED("红色"), BLUE("蓝色"), GREEN("绿色");

    private String title;

    private Color(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}

enum Num {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9);
    private int num;

    private Num(int num) {
        this.num = num;
    }

    public String toString() {
        return String.valueOf(this.num);
    }
}

public class DemoEnum {
    public static void main(String[] args) {
        for (Color temp : Color.values()) {
            System.out.println("对象序号：" + temp.ordinal() + "、对象名：" + temp.name() + "、对象内容：" + temp);
        }

        for (Num temp : Num.values()) {
            System.out.println(temp.ordinal() + " " + temp.name() + " " + temp);
        }
    }
}
