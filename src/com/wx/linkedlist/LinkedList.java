package com.wx.linkedlist;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * 带头节点的链表
 */
public class LinkedList {

    private Node headNode; //头结点

    private Node lastNode; //尾结点

    private int size;

    public LinkedList() {
        headNode = new Node("我是头结点", null);
    }

    public void add(Object e) {

        if(e == null) {
            throw  new RuntimeException("加入的元素不能为空");
        }

        Node node = new Node(e, null);

        if(lastNode == null) {
            headNode.next = node;
        } else {
            lastNode.next = node;
        }

        lastNode = node;
        size++;
    }

    public void add(int index, Object e) {
        
        if(e == null || index > size) {
            throw new IndexOutOfBoundsException("index out !, index: " + index +", size :" + size);
        }
        if(index == size) {
            add(e);
        }else {
            //add before
            Node newNode = new Node(e, null);
            
            //find location
            //找到插入位置的前一个位置
            Node node = headNode;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }

            newNode.next = node.next;
            node.next = newNode;
            size++;

        }
    }

    public Object remove(int index) {
        if(index < -1 || index > size - 1) {
            throw new IndexOutOfBoundsException("index 不合法 index:" + index + ", size is:" + size);
        }
        if(lastNode == null) throw new NoSuchElementException("元素不存在");

        Node node = headNode;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        Node object = node.next;

        node.next = node.next.next;

        size--;
        return object.object;
    }

    public Object get(int index) {
        if(index < -1 || index > size - 1) {
            throw new IndexOutOfBoundsException("index 不合法 index:" + index + ", size is:" + size);
        }
        if(lastNode == null) throw new NoSuchElementException("元素不存在");

        Node node = headNode;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.next.object;
    }

    public Object remove() {

        if(lastNode == null) {
            throw new RuntimeException("链表无元素!");
        }

        Node next = headNode.next;
        headNode.next = next.next;
        size--;
        return next;
    }

    public void update(int i, HeroNode heroNode) {

        if(lastNode == null) throw new RuntimeException("链表为空");

        if(i < -1 && i > size - 1) {
            throw new IndexOutOfBoundsException("角标越界");
        }

        Node node = headNode;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }

        Node next = node.next;
        next.object = heroNode;

    }

    public boolean isEmpty() {

        return lastNode == null;
    }

    /**
     * 从尾到头 打印单链表
     * 反向遍历
     */
    public void printReverseList() {
        if(isEmpty()) throw new RuntimeException("链表为空");

        int size = size();
        for (int i = size - 1; i >= 0 ; i--) {

            Node cur = headNode.next;
            for (int j = 0; j < i; j++) {
                cur = cur.next;
            }

            System.out.print(cur +" --> ");
        }

        System.out.println();
    }

    /**
     *  从尾到头 打印单链表
     *  使用 stack
     */
    public void printReverseList1() {
        if(isEmpty()) throw new RuntimeException("链表为空");

        Stack<Node> nodeStack = new Stack<>();

        int size = size();
        Node node = headNode.next;
        for (int i = 0; i < size; i++) {
            nodeStack.push(node);
            node = node.next;
        }

        while (! nodeStack.isEmpty()) {
            Node pop = nodeStack.pop();
            System.out.print(pop + " --> ");
        }

        System.out.println();
    }

    //反转单链表
    public void reverse() {

        if(isEmpty()) throw new RuntimeException("链表为空");

        Node newHeadNode = new Node("reverse Head", null);

        Node node = headNode.next;
        while (node != null) {

            //record node.next
            Node temp = node.next;

            node.next = newHeadNode.next;
            newHeadNode.next = node;

            //set node temp
            node = temp;
        }

        headNode.next = newHeadNode.next;

    }

    //反转单链表 不使用新建头结点
    public void reverse1() {

        //指向反转后链表的首元结点
        Node first = null;

        /*
        cur: 指向遍历的结点
        next: 指向当前结点的下一个结点
         */
        Node cur, next;

        //cur 初值设置为当前链表的首元结点
        cur = headNode.next;

        while (cur != null) {
            //保存遍历结点的下一个结点
            next = cur.next;

            cur.next = first;
            first = cur;

            //恢复遍历结点的下一个结点
            cur = next;
        }

        //设置头结点的下一个结点为first
        headNode.next = first;

    }

    //合并单链表
    public LinkedList combine(LinkedList list1) {
        LinkedList result = new LinkedList();

        Node cur, cur1;
        cur = headNode.next;
        cur1 = list1.headNode.next;

        while (cur != null && cur1 != null) {
            Integer curValue = (Integer) cur.object;
            Integer curValue1 = (Integer) cur1.object;

            if(curValue <= curValue1) {
                result.add(cur.object);
                cur = cur.next;
            }else {
                result.add(cur1.object);
                cur1 = cur1.next;
            }
        }

        while (cur != null) {
            result.add(cur.object);
            cur = cur.next;
        }

        while (cur1 != null) {
            result.add(cur1.object);
            cur1 = cur1.next;
        }

        return result;

    }

    private static class Node {

        private Object object;
        private Node next;

        public Node(Object object, Node next) {
            this.object = object;
            this.next = next;
        }

        @Override
        public String toString() {
            return object.toString();
        }
    }

    public void printLinkedList() {

        Node node = headNode.next;
        while (node != null) {
            System.out.print(node.object +" --> ");
            node = node.next;
        }
        System.out.println();
    }

    //单链表结点的个数
    public int size() {

        int size = 0;
        Node cur = headNode.next;

        while (cur != null) {
            cur = cur.next;
            size++;
        }

        return size;
    }

    //倒数第k个结点
    public Object getReverse(int k) {

        if(isEmpty()) throw new RuntimeException("链表为空");

        int size = size();

        //判断k的取值范围
        if(k < 1 || k > size) {
            throw new IndexOutOfBoundsException("k 越界不合法");
        }


        int preIndex = size - k;

        Node node = headNode;
        for (int i = 0; i < preIndex; i++) {
            node = node.next;
        }

        return node.next.object;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "headNode=" + headNode +
                ", lastNode=" + lastNode +
                ", size=" + size +
                '}';
    }
}
