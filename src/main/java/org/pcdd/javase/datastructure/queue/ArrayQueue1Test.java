package org.pcdd.javase.datastructure.queue;

/**
 * @author pcdd
 */
public class ArrayQueue1Test {
    public static void main(String[] args) {
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(3);
        queue.offer(3366);
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue.peek());
        queue.offer(4399);
        System.out.println(queue.peek());

        System.out.println(queue.size());
    }
}
