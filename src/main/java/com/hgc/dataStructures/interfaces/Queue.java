package com.hgc.dataStructures.interfaces;

/**
 * 队列接口
 */
public interface Queue<T> extends Iterable<T> {

    /**
     * 长度
     */
    public int size();

    /**
     * 头部添加
     */
    public void addFirst(T value);

    /**
     * 尾部添加
     */
    public void addLast(T value);

    /**
     * 添加
     */
    default public void add(T value){
        addLast(value);
    }

    /**
     * 获取头部元素
     */
    public T getFirst();

    /**
     * 获取尾部元素
     */
    public T getLast();
}
