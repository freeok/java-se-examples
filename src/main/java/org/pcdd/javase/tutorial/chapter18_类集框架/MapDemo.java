package org.pcdd.javase.tutorial.chapter18_类集框架;

import java.util.HashMap;
import java.util.Map;

class Me {
    private String id;
    private String name;


}

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put(String.valueOf(i), i);
        }

        System.out.println(map);
    }
}
