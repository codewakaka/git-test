package com.laoma.mystudy.collection;

import java.util.Arrays;

public class DynamicArray<E> {

    private static int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData;

    public DynamicArray() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e) {
        //扩容
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }

    private void ensureCapacity(int minCapacity) {
        //获取旧的长度
        int oldCapacity = elementData.length;
        //比较新旧长度
        if (oldCapacity > minCapacity) {
            return;
        }
        //老的长度变为2倍
        int newCapacity = oldCapacity * 2;
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }

    public E set(int index, E element) {
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    public <T extends E> void addAll(DynamicArray<T> c) {
        for (int i = 0; i < c.size; i++) {
            add(c.get(i));
        }
    }
}
