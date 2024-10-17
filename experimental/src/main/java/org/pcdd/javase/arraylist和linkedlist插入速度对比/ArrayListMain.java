package org.pcdd.javase.arraylist和linkedlist插入速度对比;

/**
 * 仿照ArrayList
 */
class ArrayList {
    private Object[] elementData;
    private int size;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public boolean add(int e) {
        grow();
        elementData[size++] = e;
        return true;
    }

    public int remove(int index) {
        rangeCheckForAdd(index);
        Object delValue = elementData[index];
        int numMoved = size - index - 1;
        if (numMoved >= 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
            elementData[--size] = null;
        }
        return (int) delValue;
    }

    private void grow() {
        if (size == elementData.length) {
            Object[] newArray = new Object[size * 3 / 2 + 1];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
    }

    public int get(int index) {
        rangeCheckForAdd(index);
        return (int) elementData[index];
    }

    public int set(int index, int e) {
        rangeCheckForAdd(index);
        Object oldValue = elementData[index];
        elementData[index] = e;
        return (int) oldValue;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 检查数组下标是否越界
     *
     * @param index 下标
     */
    private void rangeCheckForAdd(int index) {
        if (index >= size) {
            throw new IllegalArgumentException("数组下标越界:" + index);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(elementData[i]);
            sb.append(",");
        }
        sb.append(elementData[size - 1]);
        sb.append("]");

        return sb.toString();
    }
}

/**
 * @author pcdd
 * date 2021/4/10 1:44
 */
public class ArrayListMain {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }

        System.out.println(list);

        list.remove(9);
        System.out.println(list);
    }
}


