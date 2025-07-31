package com.hgc.dataStructures.List.LinkedList;

import java.util.Iterator;

/**
 * 单链表
 */
public class LinkedList<T> implements Iterable<T> {

    /**
     * 头节点 不存储信息
     */
    private Node<T> head;

    /**
     * 长度
     */
    private int size;


    public LinkedList() {
        this.head = new Node<>();
        this.size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {

        Node<T> node = head;

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public T next() {
            node = node.next;
            return node.value;
        }
    }

    /**
     * 节点类
     */
    private static class Node<T> {
        T value;
        Node<T> next;

        public Node() {
            this.value = null;
            this.next = null;
        }

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    /**
     * 添加
     */
    public void add(T value) {
        addLast(value);
    }

    /**
     * 头部添加
     */
    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        node.next = head.next;
        head.next = node;
    }

    /**
     * 末尾添加
     */
    public void addLast(T value) {

        Node<T> node = new Node<>(value);

        Node<T> current = head;

        while (current.next != null) {
            current = current.next;
        }

        size++;

        current.next = node;
    }


    @Override
    public String toString() {
        Iterator<T> iterator = iterator();
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (iterator.hasNext()) {
            T next = iterator.next();
            sb.append(next);

            if(!iterator.hasNext()){
                break;
            }
            sb.append(",").append(" ");
        }

        sb.append("]");
        return sb.toString();
    }
}
