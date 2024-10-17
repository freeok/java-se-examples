package org.pcdd.javase.chapter12_内部类.四种方法引用;

@FunctionalInterface
interface IFunction1<P, R> {
    // 引用普通方法
    R trim(P str);
}

@FunctionalInterface
interface IFunction2<P, R> {
    // 引用静态方法
    R valueOf(P num);
}

@FunctionalInterface
interface IFunction3<P> {
    // 引用特定普通方法
    int compareTo(P s1, P s2);
}

@FunctionalInterface
interface IFunction4<R> {
    // 引用构造方法
    R create(String name, int age);
}

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // 引用普通方法
        IFunction1<String, String> fun1 = String::trim;
        System.out.println(fun1.trim(" pcdd "));
        // 引用静态方法
        IFunction2<Integer, String> fun2 = String::valueOf;
        System.out.println(fun2.valueOf(100).length());
        // 引用特定普通方法
        IFunction3<String> fun3 = String::compareTo;
        System.out.println(fun3.compareTo("Main", "a"));
        // 引用构造方法
        IFunction4<Student> fun4 = Student::new;
        System.out.println(fun4.create("pcdd", 20));
    }
}
