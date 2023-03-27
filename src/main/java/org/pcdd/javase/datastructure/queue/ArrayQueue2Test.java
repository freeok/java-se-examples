package org.pcdd.javase.datastructure.queue;

/**
 * @author pcdd
 * date 2023/03/27 00:24
 */
public class ArrayQueue2Test {
    public static void main(String[] args) {
        ArrayQueue2<Integer> queue = new ArrayQueue2<>(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        queue.poll();
        for (Integer integer : queue) {
            System.out.println(integer);
        }
    }
}
