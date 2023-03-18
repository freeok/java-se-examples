package org.pcdd.javase.tutorial.chapter18_类集框架.ex;

import java.util.Scanner;

/**
 * 抽象类练习
 */

abstract class AbstractShape {
    private double area;
    private double girth;

    public AbstractShape() {

    }

    /**
     * 画出形状
     */
    public abstract void draw();

    /**
     * 计算面积
     *
     * @return 返回图形面积
     */
    public abstract double calArea();

    /**
     * 计算周长
     *
     * @return 返回图形周产
     */
    public abstract double calGirth();
}

class Circle extends AbstractShape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public void draw() {
        System.out.println("画圆形");
    }

    @Override
    public double calArea() {
        return Math.PI * r * r;
    }

    @Override
    public double calGirth() {
        return 2 * Math.PI * r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double r = sc.nextDouble();
        AbstractShape circle1 = new Circle(10);
        Circle circle2 = (Circle) circle1;

        System.out.printf("半径为%.2f圆形的面积：%.2f\n", circle2.getR(), circle1.calArea());
        System.out.printf("半径为%.2f圆形的周长：%.2f", circle2.getR(), circle1.calGirth());
    }
}
