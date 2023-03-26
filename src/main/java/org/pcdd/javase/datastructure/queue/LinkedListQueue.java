package org.pcdd.javase.datastructure.queue;

import java.util.Iterator;

/**
 * 数据结构：队列
 * 单项环形哨兵链表实现
 *
 * @author pcdd
 */
public class LinkedListQueue<E> implements Queue<E> {

    private Node<E> head = new Node<>(null, null);
    private Node<E> tail = head;
    private int size;
    private int capacity = Integer.MAX_VALUE;

    public LinkedListQueue() {
        this.tail.next = head;
    }

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
        this.tail.next = head;
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            System.out.println("队列已满！");
            return false;
        }
        Node<E> added = new Node<>(value, head);
        tail.next = added;
        tail = added;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        // 第一个节点
        Node<E> first = head.next;
        // 删除第一个节点
        head.next = first.next;
        // 只有一个结点时
        if (tail == first) {
            // 删除后，tail需指向head
            tail = head;
        }
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        return isEmpty() ? null : head.next.value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != head;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

}
