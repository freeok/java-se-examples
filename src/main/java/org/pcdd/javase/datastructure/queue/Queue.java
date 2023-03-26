package org.pcdd.javase.datastructure.queue;

/**
 * @author pcdd
 */
public interface Queue<E> extends Iterable<E> {

    /**
     * 队尾插入元素
     */
    boolean offer(E value);

    /**
     * 队头弹出元素，并返回
     */
    E poll();

    /**
     * 返回队头元素
     */
    E peek();

    /**
     * 返回元素个数
     */
    int size();

    boolean isEmpty();

    boolean isFull();

}
