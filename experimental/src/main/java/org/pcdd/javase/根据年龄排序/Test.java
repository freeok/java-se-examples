package org.pcdd.javase.根据年龄排序;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void printArrayList(List<Student> list) {
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.name + " " + student.age);
        }
    }

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
}

public class Test {
    public static void main(String[] args) {
        Student stu1 = new Student("a同学", 20);
        Student stu2 = new Student("b同学", 18);
        Student stu3 = new Student("c同学", 19);
        Student stu4 = new Student("d同学", 21);
        Student stu5 = new Student("e同学", 22);

        ArrayList<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);
        list.add(stu5);
        Student.printArrayList(list);

        list.sort(Comparator.comparingInt(Student::getAge).thenComparing(Student::getName));

        System.out.println("==========================");
        Student.printArrayList(list);


    }
}
