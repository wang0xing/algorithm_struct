package com.wx.linkedlist;

public class Test1 {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.printLinkedList();

        //list 反转
        list.reverse1();

        //打印list
        list.printLinkedList();


        list.printReverseList();


        //合并单链表练习
        LinkedList list1 = new LinkedList();
        list1.add(2);
        list1.add(4);
        list1.add(6);

        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(3);
        list2.add(10);


        System.out.println("list1: ");
        list1.printLinkedList();

        System.out.println("list2: ");
        list2.printLinkedList();

        LinkedList list3 =  list1.combine(list2);

        System.out.println("list3: ");
        list3.printLinkedList();

    }
}
