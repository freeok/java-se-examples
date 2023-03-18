package org.pcdd.javase.tutorial.chapter18_类集框架.ex;

/**
 * 这是一个练习类，可能会随时修改
 *
 * @author pcdd
 * date 2020/11/1 14:26
 */

class Human {
    private String name;
    private int age;
    private String sex;

    public Human(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void eat() {
        System.out.println(this.name + "正在吃饭...");
    }

    public void sleep() {
        System.out.println(this.name + "正在睡觉...");
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

class Student extends Human {
    private String studentNo;
    private String className;
    private String major;
    private String dept;

    public Student(String name, int age, String sex
            , String studentNo, String className, String major, String dept) {
        super(name, age, sex);
        this.studentNo = studentNo;
        this.className = className;
        this.major = major;
        this.dept = dept;
    }

    public void study() {
        System.out.println(super.getName() + "正在学习...");
    }

    public void doHomeWork() {
        System.out.println(super.getName() + "正在写作业...");
    }

    @Override
    public void sleep() {
        System.out.println(super.getName() + "今天不睡了...");
    }
}

class Teacher extends Human {
    private String teacherNo;
    private String title;
    private double salary;

    public Teacher(String name, int age, String sex, String teacherNo, String title, double salary) {
        super(name, age, sex);
        this.teacherNo = teacherNo;
        this.title = title;
        this.salary = salary;
    }

    public void teach() {
        System.out.println(super.getName() + "正在讲课...");
    }

    public void work() {
        System.out.println(super.getName() + "正在工作...");
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}


public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("pc", 20, "男"
                , "2011302115", "软工升本20-2", "软件工程", "信息技术学院");
        student1.eat();
        student1.sleep();
        student1.study();
        student1.doHomeWork();

        System.out.println("=========================");

        Teacher teacher1 = new Teacher("邵老师", 30, "女", "10001", "讲师", 10000);
        teacher1.eat();
        teacher1.sleep();
        teacher1.teach();
        teacher1.work();

    }

}
