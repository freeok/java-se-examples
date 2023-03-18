package org.pcdd.javase.tutorial.chapter8_继承;

import java.util.Scanner;

/***
 * this和super示例
 */

class Father {
    private String name;

    public Father() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Son extends Father {
    private String school;

    public Son(String name, String school) {
        super.setName(name);
        this.school = school;
    }

    public void show() {
        System.out.println("姓名" + super.getName() + "\t学校:" + this.school);
    }
}

public class Demo_this_super {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 输入姓名和学校
        Son one = new Son(sc.nextLine(), sc.nextLine());
        one.show();
    }
}


