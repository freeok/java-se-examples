package org.pcdd.javase.tutorial.chapter18_类集框架;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }

        ListIterator<Integer> iterator = linkedList.listIterator();

        long s1 = System.currentTimeMillis();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        long e1 = System.currentTimeMillis();
        System.out.printf("\n%dms\n", e1 - s1);

        long s2 = System.currentTimeMillis();
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " ");
        }
        long e2 = System.currentTimeMillis();
        System.out.printf("\n%dms\n", e2 - s2);
    }
}
