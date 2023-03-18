package org.pcdd.javase.tutorial.chapter11_异常的捕获与处理;

// Exception异常必须处理，RuntimeException异常可以不处理

public class ExceptionMain {
    public static int add(int... args) throws RuntimeException {
        return args[0] / args[1];
    }

    public static void main(String[] args) {
        /*System.out.println("开始！");
        try {
            System.out.println(add(10, 0));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("结束！");
        }*/
        System.out.println(add(10, 0));
    }
}
