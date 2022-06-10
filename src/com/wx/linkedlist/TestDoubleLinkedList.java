package com.wx.linkedlist;

public class TestDoubleLinkedList {

    public static void main(String[] args) {

        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

//        list.remove(0);

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.printLinkedList();

        System.out.println("size: " + list.size());
        System.out.println(list);

        System.out.println(list.remove(0));
        System.out.println("after remove index 3:");
        list.printLinkedList();



    }
}
