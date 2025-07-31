package com.hgc.dataStructures.List;

public interface List<T> extends Iterable<T> {

    /**
     * 长度
     */
    public int size();

    /**
     * 添加
     */
    public void add(T value);

    /**
     * 获取
     */
    public T get(int index);

    /**
     * 删除
     */
    public void remove(int index);

    /**
     * 插入
     */
    public void insert(int index,T value);

    /**
     * 是否存在这个元素
     */
    public boolean contains(Object value);

    /**
     * 是否为空
     */
    public boolean isEmpty();
}
