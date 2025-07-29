package com.hgc.dataStructures.List;

import java.util.Arrays;

/**
 * 动态数组
 */
public class ArrayList<T> {

    /**
     * 逻辑大小
     */
    private int size;

    /**
     * 容量
     */
    private int capacity;

    /**
     * 数据
     */
    private Object[] array;

    public ArrayList() {
        this.size = 0;
        this.capacity = 10;
        this.array = new Object[this.capacity];
    }

    /**
     * 添加一个值
     */
    public void add(T value) {
        addLast(value);
    }

    /**
     * 在尾部添加
     */
    public void addLast(T value) {
        this.array[size] = value;
        size++;
    }

    /**
     * 根据 index 获取 值
     */
    public T get(int index) {

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        return (T) array[index];
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
}
