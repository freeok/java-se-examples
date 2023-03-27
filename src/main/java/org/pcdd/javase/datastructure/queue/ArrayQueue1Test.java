package org.pcdd.javase.datastructure.queue;

/**
 * @author pcdd
 * date 2023/03/27 00:24
 */
public class ArrayQueue1Test {
    public static void main(String[] args) {
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(1);
        queue.offer(3366);
        System.out.println(queue.peek());
        queue.poll();
        queue.offer(4399);
        System.out.println(queue.peek());

        System.out.println(queue.size());
    }
}
