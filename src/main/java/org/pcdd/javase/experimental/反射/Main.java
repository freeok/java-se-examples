package org.pcdd.javase.experimental.反射;

import java.lang.reflect.Method;

/**
 * @author pcdd
 * 2020/10/28 12:07
 */

class Animal {
    private String name;

    public void eat() {
        System.out.println("吃饭...");
    }

    private void sleep() {
        System.out.println("睡觉...");
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Class<Animal> clazz = Animal.class;
            Method eat = clazz.getMethod("eat");
            eat.invoke(clazz.getDeclaredConstructor().newInstance());
            Method[] methods = clazz.getMethods();
            for (Method m : methods) {
                System.out.println(m);
            }

        } catch (Exception e) {
        }
    }
}
