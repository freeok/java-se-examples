package org.pcdd.javase.chapter8_继承;

/**
 * Object有三种方法最常用：
 * hashCode方法、equals方法、toString方法
 */

public class book8_6_Object {
    public static void main(String[] args) {

        // Object可以用来接收任何数据
        Object obj = new Person1();// 向上转型
        if (obj instanceof Person1) {
            Person1 per = (Person1) obj;// 向下转型
        }

        /*Object下的hashCode方法：哈希码代表对象的特征。
         哈希码并不是完全唯一的，它是一种算法，让同一个类的对象按照自己不同的特征尽量的有不同的哈希码，但不表示不同的对象哈希码完全不同。
         例如对于String类中的hashCode方法，是一个算法;而Integer类下的hashCode方法返回的是对象本身，即一个整数*/

        // 对于String类，只要字符串内容相同，返回的哈希码也相同。
        System.out.println("aaa".hashCode());
        System.out.println(new String("aaa").hashCode());// 虽然"aaa"和new String("aaa")的地址不同，但内容相同，故哈希码也相同
        System.out.println("bbb".hashCode());

        // Integer对象的哈希码是本身
        System.out.println(new Integer(100).hashCode());

    }
}

class Person1 {

}

