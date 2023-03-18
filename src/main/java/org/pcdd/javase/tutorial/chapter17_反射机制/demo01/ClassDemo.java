package org.pcdd.javase.tutorial.chapter17_反射机制.demo01;

class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print() {
        System.out.println(this.name + " " + this.age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ClassDemo {
    public static void main(String[] args) throws Exception {
        /*Class<?> class1 = Class.forName("demo01.Student");*/
       /* Class<Student> class2 = Student.class;
        Class<? extends Student> class3 = new Student().getClass();

        System.out.println(class1 == class2);
        System.out.println(class1 == class3);
        System.out.println(class2 == class3);*/

        // Class类对象
        Student stu = Student.class
                .getDeclaredConstructor(String.class, int.class)
                .newInstance("dpc", 20);

        System.out.println(stu);
    }
}
