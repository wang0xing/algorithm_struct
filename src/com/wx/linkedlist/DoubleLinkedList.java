package com.wx.linkedlist;

public class DoubleLinkedList<T> {

    public T remove(int index) {


        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index 不合法");
        }

        Node<T> cur = headNode.next;
        for (int j = 0; j < index; j++) {
            cur = cur.next;
        }

        cur.prev.next = cur.next;
        if(cur.next != null) {
            cur.next.prev = cur.prev;
        }

        size--;
        return cur.data;
    }

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
           return data.toString();
        }
    }

    public DoubleLinkedList() {
        headNode = new Node<T>(null, null, null);
    }

    private Node<T> headNode;

    private Node<T> lastNode;

    private int size;

    public void add(T e) {
        Node<T> tNode = new Node<>(e, null, null);
        if(lastNode == null) {
            lastNode = tNode;
            lastNode.prev = headNode;

            headNode.next = lastNode;
        }else {
            lastNode.next = tNode;

            tNode.prev = lastNode;

            lastNode = tNode;
        }

        size++;
    }

    public void printLinkedList() {
        Node cur = headNode.next;
        while (cur != null) {
            System.out.print(cur + " --> ");
            cur = cur.next;
        }
        System.out.println();
    }

    public int size() {
        //return size;
        int size = 0;

        Node cur = headNode.next;
        while (cur != null) {
            size++;
            cur = cur.next;
        }

        return size;
    }

    @Override
    public String toString() {
        return "DoubleLinkedList{" +
                ", lastNode=" + lastNode +
                ", size=" + size +
                '}';
    }
}
