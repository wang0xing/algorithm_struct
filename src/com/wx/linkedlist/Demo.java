package com.wx.linkedlist;

public class Demo {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }

        Object remove =  list.remove();
        System.out.println(remove);
        list.remove();

        list.printLinkedList();
        System.out.println();
        System.out.println(list);

    }
}
