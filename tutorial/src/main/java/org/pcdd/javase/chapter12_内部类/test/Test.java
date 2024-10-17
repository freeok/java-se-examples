package org.pcdd.javase.chapter12_内部类.test;

@FunctionalInterface
interface IMessage {
    String getMessage(String str);
}

public class Test {
    public static void main(String[] args) {


        IMessage message = String::toUpperCase;
        System.out.println(message.getMessage("pcdd"));

       /* Function<Integer, String> function = String::valueOf;
        System.out.println(function.apply(100).length());

        Consumer<String> con = System.out::println;
        con.accept("123");

        Supplier<String> supplier = "PCDD.work"::toLowerCase;
        System.out.println(supplier.get());

        Predicate<String> predicate = "pcdd.work"::endsWith;
        System.out.println(predicate.test("work"));*/
    }
}
