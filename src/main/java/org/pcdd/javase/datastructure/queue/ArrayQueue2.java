package org.pcdd.javase.datastructure.queue;

import java.util.Iterator;

/**
 * ArrayQueue1 改进版，用size辅助判断空满
 * 问题：当head或tail为Integer.MAX_VALUE+1时，求余计算索引会超出int范围
 *
 * @author pcdd
 */
public class ArrayQueue2<E> implements Queue<E> {
    private final E[] array;
    private int head;
    private int tail;
    // 元素个数
    private int size;

    public ArrayQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        head = (head + 1) % array.length;
        size--;
        return value;
    }

    @Override
    public E peek() {
        return isEmpty() ? null : array[head];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int p = head;
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                E value = array[p];
                p = (p + 1) % array.length;
                count++;
                return value;
            }
        };
    }
}
