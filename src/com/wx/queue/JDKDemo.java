package com.wx.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class JDKDemo {
    public static void main(String[] args) {
        Queue queue = new ArrayDeque();

        for (int i = 0; i < 17; i++) {
            queue.add(i);
        }

        System.out.println(queue);

        Object remove = queue.remove();

        System.out.println(remove);
        System.out.println(queue);
    }
}
