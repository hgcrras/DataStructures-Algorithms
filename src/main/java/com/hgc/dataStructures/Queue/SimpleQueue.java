package com.hgc.dataStructures.Queue;

import com.hgc.dataStructures.List.ArrayList;
import com.hgc.dataStructures.interfaces.Queue;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 简单队列 固定长度
 */
public class SimpleQueue<T> implements Queue<T> {

    /**
     * 长度
     */
    private int size;

    /**
     * 容量
     */
    private int capacity;

    /**
     * 数据
     */
    private Object[] data;

    /**
     * 默认给100容量
     */
    public SimpleQueue() {
        this.size = 0;
        this.capacity = 100;
        this.data = new Object[this.capacity];
    }

    /**
     * 自定义容量
     */
    public SimpleQueue(int size) {
        this.size = 0;
        this.capacity = size;
        this.data = new Object[size];
    }

    /**
     * 尾部添加
     */
    @Override
    public void addLast(T value) {
        checkQueueFull(size);
        data[size++] = value;
    }

    /**
     * 长度
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 头部添加
     */
    @Override
    public void addFirst(T value) {
        checkQueueFull(size + 1);

        for (int i = size; i >= 0; i--) {
            data[i + 1] = data[i];
        }

        data[0] = value;
    }

    /**
     * 检查队列是否已满
     */
    private void checkQueueFull(int index) {
        if (index >= capacity) {
            throw new IllegalStateException("Queue Is Full");
        }
    }

    /**
     * 获取头部元素
     */
    @Override
    @SuppressWarnings("unchecked")
    public T getFirst() {
        return (T) data[0];
    }

    /**
     * 获取尾部元素
     */
    @Override
    @SuppressWarnings("unchecked")
    public T getLast() {
        return (T) data[size - 1];
    }

    /**
     * 获取迭代器
     */
    @Override
    public Iterator<T> iterator() {
        return new SimpleQueueIterator();
    }

    /**
     * 自定义迭代器
     */
    private class SimpleQueueIterator implements Iterator<T> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            return (T) data[cursor++];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                sb.append(data[i]).append(",").append(" ");
            } else {
                sb.append(data[i]);
            }
        }

        sb.append("]");

        return sb.toString();
    }
}