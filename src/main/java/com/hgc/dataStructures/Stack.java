package com.hgc.dataStructures;

import com.hgc.dataStructures.List.ArrayList;

/**
 * 栈 先进后出
 */
public class Stack<T> {

    private Object[] data;
    private int size;
    private int head;

    public Stack(int size) {
        this.head = 0;
        this.size = size;
        this.data = new Object[size + 1];
    }

    /**
     * 压栈 添加
     */
    public T push(T value) {

        if (head >= size) {
            throw new RuntimeException("Stack Is Overflow");
        }

        data[++head] = value;
        return (T) data[head];
    }

    /**
     * 获取栈顶元素
     */
    public T get() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Is Empty");
        }

        return (T) data[head];
    }

    /**
     * 弹出 删除
     */
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Is Empty");
        }

        return (T) data[head--];
    }

    /**
     * 栈是否为空
     */
    public boolean isEmpty() {
        return head == 0;
    }

}
