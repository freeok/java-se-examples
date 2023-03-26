package org.pcdd.javase.datastructure.queue;

/**
 * @author pcdd
 */
public class LinkedListQueueTest {
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>(3);
        System.out.println("linkedListQueue.isEmpty() = " + queue.isEmpty());
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println("linkedListQueue.isEmpty() = " + queue.isEmpty());
        print(queue);
        System.out.println("linkedListQueue.size() = " + queue.size());

        System.out.println("linkedListQueue.peek() = " + queue.peek());

        System.out.println("linkedListQueue.poll() = " + queue.poll());
        print(queue);
        System.out.println("linkedListQueue.size() = " + queue.size());
    }

    static void print(LinkedListQueue<Integer> linkedListQueue) {
        for (Integer integer : linkedListQueue) {
            System.out.println("Node value: " + integer);
        }
    }
}
