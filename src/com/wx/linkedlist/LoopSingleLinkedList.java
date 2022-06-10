package com.wx.linkedlist;

public class LoopSingleLinkedList<T> {

    public T remove(int index) {

        return null;
    }

    public LoopSingleLinkedList() {
    }

    private Node<T> first;

    private Node<T> last;

    private int size;

    public void add(T e) {
        Node<T> tNode = new Node<>(e,  null);
        tNode.next = first;
        if(last == null) {
            last = tNode;
            first = tNode;
        }else {
            last.next = tNode;
            last = tNode;
        }

        size++;
    }

    public void printLinkedList() {

        if(first == null) {
            System.out.println("链表为空");
            return;
        }

        Node cur = first;

        do {
            System.out.print(cur + " --> ");
            cur = cur.next;
        }while (cur != first);


        System.out.print(cur);
        System.out.println();
    }

    public int size() {
        //return size;
        int size = 0;

        Node cur = first;
        while (cur != last) {
            size++;
            cur = cur.next;
        }
        size++;
        return size;
    }

    @Override
    public String toString() {
        return "DoubleLinkedList{" +
                ", lastNode=" + first +
                ", size=" + size +
                '}';
    }

    /**
     *
     * 数据总数： n
     * 开始的编号：1
     * 每次数 m 下
     * @param m
     */
    public void printYSF(int m) {

        int n = size();

        Node cur = first;
        Node pre = last;

        int length = 0;
        while (length < n) {

            for (int i = 0; i < m - 1; i++) {
                cur = cur.next;
                pre = pre.next;
            }
            System.out.print(cur.data +" ");

            cur = cur.next;
            pre.next = cur;

            length++;
        }

    }

    public void printYSF1(int startNo, int m) {

        Node cur = first;
        Node pre = last;

        //cur, pre 移动到startNo处 ， 总共一点m-1次
        for (int i = 0; i < startNo - 1; i++) {
            cur = cur.next;
            pre = pre.next;
        }

        //per=cur 代表已经到最后一个元素 结束
        while (pre != cur) {

            //每次移动 m-1 次
            for (int i = 0; i < m - 1; i++) {
                cur = cur.next;
                pre = pre.next;
            }

            //此时 cur 指向要出去的元素
            System.out.print(cur + "\t");

            //cur pre 继续往后走
            cur = cur.next;
            pre.next = cur;
        }

        //pre 或 cur 指向最后一个元素
        System.out.print(cur);

        System.out.println();

    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
