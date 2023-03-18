package org.pcdd.javase.tutorial.chapter18_类集框架;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListDemo {

    public static void main(String[] args) {
        List<String> all = List.of("one", "two", "three");

        System.out.println("ArrayList集合");
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list1.add(String.valueOf(i));
        }
        System.out.println(list1);
        list1.add(1, "123");
        System.out.println(list1);

        /////////////////////////////////////////

        System.out.println();
        System.out.println("LinkedList集合");
        List<String> list2 = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list2.add(String.valueOf(i));
        }
        System.out.println(list2);
        list2.remove(4);
        System.out.println(list2);

        /////////////////////////////////////////

        System.out.println();
        System.out.println("Vector集合");
        List<String> list3 = new Vector<>();
        for (int i = 0; i < 5; i++) {
            list3.add(String.valueOf(i));
        }
        System.out.println(list3);
        list3.remove(4);
        System.out.println(list3);


    }
}
