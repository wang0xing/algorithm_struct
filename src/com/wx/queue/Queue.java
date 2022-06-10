package com.wx.queue;

import java.util.Arrays;

public class Queue {

    private Object[] objects;

    private int front;
    private int real;

    private int size;

    public Queue(int capacity) {
        this.objects = new Object[capacity];
    }

    public void add(Object o) {

        if(isFull()) {
            throw new RuntimeException("队列满了，无法加入！");
        }

        this.objects[real] = o;
        real++;
        size++;
    }

    public Object remove() {
        if(isEmpty()) {
            throw new RuntimeException("队列空，无法取！");
        }

        Object o = this.objects[front++];
        size--;
        return o;
    }

    private boolean isEmpty() {

        return front == real;
    }

    private boolean isFull() {
        return front == objects.length;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "objects=" + Arrays.toString(objects) +
                ", front=" + front +
                ", real=" + real +
                ", size=" + size +
                '}';
    }
}
