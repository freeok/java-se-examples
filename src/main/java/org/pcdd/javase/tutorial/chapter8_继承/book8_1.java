package org.pcdd.javase.tutorial.chapter8_继承;

/**
 * 显式继承：直接利用对象操作
 * 隐式继承：父类属性为private，子类间接访问父类成员(通过Getter/Setter操作)
 */

// 下为类继承定义Demo & 隐式继承Demo
public class book8_1 {
    public static void main(String[] args) {
        Student one = new Student("pcdd", 20, 666);
        one.show();
    }
}

class Student extends Person {
    private long id;

    public Student(String name, int age, long id) {
        setName(name);
        setAge(age);
        this.id = id;
    }

    public void show() {
        System.out.println("学号：" + this.id);
        System.out.println("姓名：" + getName() + "\n年龄：" + getAge());

    }
}

class Person {
    private String name;
    private int age;

    // 直接调用
    /*public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*public void show() {
        System.out.println("姓名：" + this.name + "\n年龄：" + this.age);
    }*/
}
