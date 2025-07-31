package com.hgc.dataStructures.List;

import com.hgc.dataStructures.interfaces.List;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 动态数组
 */
public class ArrayList<T> implements List<T> {

    /**
     * 逻辑大小
     */
    private int size;

    /**
     * 容量
     */
    private int capacity;

    /**
     * 数组
     */
    private Object[] array;

    public ArrayList() {
        this.size = 0;
        this.capacity = 10;
        this.array = new Object[this.capacity];
    }

    public ArrayList(int size) {
        this.size = size;
        this.capacity = size;
        this.array = new Object[this.capacity];
    }

    /**
     * 长度
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * 添加一个值
     */
    @Override
    public void add(T value) {
        addLast(value);
    }

    /**
     * 在尾部添加
     */

    public void addLast(T value) {
        checkCapacity(size + 1);
        this.array[size] = value;
        size++;
    }

    /**
     * 根据 index 获取 值
     */
    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        return (T) array[index];
    }

    /**
     * 删除
     *
     * @param index
     */
    @Override
    public void remove(int index) {

    }

    /**
     * 是否存在这个元素
     *
     * @param value
     */
    @Override
    public boolean contains(Object value) {
        return false;
    }

    /**
     * 获取第一个值
     */
    public T getFirst() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("数组为空");
        }
        return get(0);
    }

    /**
     * 插入
     */
    @Override
    public void insert(int index, T value) {
        checkCapacity(size + 1);

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        size++;
        array[index] = value;
    }

    /**
     * 获取最后一个值
     */
    public T getLast() {

        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("数组为空");
        }

        return get(size - 1);
    }

    /**
     * 检查是否需要扩容
     */
    private void checkCapacity(int capacity) {
        if (this.capacity < capacity) {
            grow(capacity);
        }
    }

    /**
     * 扩容
     */
    private void grow(int minCapacity) {
        int oldCapacity = array.length;
        // 扩容为原来的 1.5 倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }

        Object[] temp = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }

        capacity = newCapacity;
        array = temp;
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                sb.append(array[i]);
            } else {
                sb.append(array[i]);
                sb.append(",");
            }
        }

        sb.append("]");

        return sb.toString();
    }

    /**
     * 迭代器 增强for
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void forEach(Consumer<? super T> action) {
        for (int i = 0; i < size; i++) {
            action.accept((T) array[i]);
        }
    }


    /**
     * 迭代器实现
     */
    private class ArrayListIterator implements Iterator<T> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }


        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            return (T) array[cursor++];
        }
    }

}