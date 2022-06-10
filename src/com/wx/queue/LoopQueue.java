package com.wx.queue;

import java.util.Arrays;

public class LoopQueue {

    private Object[] data;
    private int  front;
    private int real;

    private int size;

    public LoopQueue(int size) {
        this.data = new Object[size];
    }

    public void add(Object element) {

        //是否满
        if(isFull()) {
            throw new RuntimeException("队列满，无法加入");
        }

        data[real] = element;
        real = (real + 1 + data.length) % data.length;


        size++;

    }

    public boolean isFull() {

        return size == data.length;
    }

    public Object remove() {

        if(isEmpty()) {
            throw new RuntimeException("队列空， 无法取");
        }

        Object datum = data[front];

        data[front] = null;

        front = (front + 1 + data.length) % data.length;

        size--;
        return datum;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "LoopQueue{" +
                "data=" + Arrays.toString(data) +
                ", front=" + front +
                ", real=" + real +
                ", size=" + size +
                '}';
    }
}
