package org.pcdd.javase.datastructure.queue;

import java.util.Iterator;

/**
 * 数据结构：队列
 * 环形数组实现 方法1
 * 缺点：tail指针指向的位置不能存储元素
 *
 * @author pcdd
 * date 2023/03/27 00:02
 */
public class ArrayQueue1<E> implements Queue<E> {

    private final E[] array;
    private int head;
    private int tail;

    public ArrayQueue1(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        head = (head + 1) % array.length;
        return value;
    }

    @Override
    public E peek() {
        return isEmpty() ? null : array[head];
    }

    @Override
    public int size() {
        return array.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % array.length == head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p];
                p = (p + 1) % array.length;
                return value;
            }
        };
    }

}
