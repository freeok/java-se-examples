package org.pcdd.javase.tutorial.chapter15_常用类库.Calendar类;

import java.util.Calendar;

/**
 * Calendar类的成员方法
 */
public class Demo01Calendar {
    public static void main(String[] args) {
        demo01();
    }

    private static void demo01() {
        Calendar calendar = Calendar.getInstance();
        // calendar.set(2049, 10, 1);

        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);

        int month = calendar.get(Calendar.MONTH);
        System.out.println(month);

        int day = calendar.get(Calendar.DATE);
        System.out.println(day);


    }
}
