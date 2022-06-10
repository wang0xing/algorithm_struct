package com.wx.linkedlist;

public class Test3 {
    public static void main(String[] args) {

        LoopSingleLinkedList<Integer> loopSingleLinkedList = new LoopSingleLinkedList();

//        loopSingleLinkedList.add(1);
//        loopSingleLinkedList.add(2);
//        loopSingleLinkedList.add(3);
//        loopSingleLinkedList.add(4);
//        loopSingleLinkedList.add(5);

        for (int i = 0; i < 25; i++) {
            loopSingleLinkedList.add(i+1);
        }

        loopSingleLinkedList.printLinkedList();
/*

        System.out.println(loopSingleLinkedList.size());
        loopSingleLinkedList.printYSF(3);
*/
//        loopSingleLinkedList.printYSF(2);

        loopSingleLinkedList.printYSF1(1, 2);


    }
}
