package com.wx.binary_tree;

import java.util.*;

public class Tree<T extends Comparable<T>> {

    private Node<T>[] arrayTree;

    private int size;

    public void infixOrder(Node<T> root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            infixOrder(root.left);
        }
        System.out.println(root);
        if (root.right != null) {
            infixOrder(root.right);
        }
    }

    public int height(Node<T> node) {

        if (node == null) {
            return -1;
        }

        int leftTreeHeight = height(node.left);
        int rightTreeHeight = height(node.right);

        return Math.max(leftTreeHeight, rightTreeHeight) + 1;

    }

    public void style(char c) {
        System.out.print(c);
    }

    public void show(Node<T>[] nodes, int depth, int height) {

        Node<T>[] newNodes = new Node[1 << (depth + 1)];
        int nextIndex = 0;
        for (int i = 0; i < nodes.length; i++) {

            Node<T> node = nodes[i];
            if (node == null) {

                for (int j = 0; j < (1 << height); j++) {
                    style('\t');
                }

                System.out.print("N");

                for (int j = 0; j < (1 << height); j++) {
                    style('\t');
                }


                nextIndex++;
                nextIndex++;
            } else {

                for (int j = 0; j < (1 << height); j++) {
                    style('\t');
                }
                System.out.print(node);
                newNodes[nextIndex++] = node.left;
                newNodes[nextIndex++] = node.right;

                for (int j = 0; j < (1 << height); j++) {
                    style('\t');

                }

            }

        }
        System.out.println();


        if (checkAllNull(newNodes)) {
            return;
        }

        printNextLine('-', nodes.length, height);

        System.out.println();


        show(newNodes, ++depth, --height);
    }


    public void show1(Node<T>[] nodes, int depth, int height) {

        Node[] newNodes = new Node[1 << (depth + 1)];
        int nextIndex = 0;
        for (int i = 0; i < nodes.length; i++) {

            Node<T> node = nodes[i];
            if (node == null) {

                for (int j = 0; j < (1 << height); j++) {
                    style('\t');
                }

                System.out.print(" ");

                for (int j = 0; j < (1 << height); j++) {
                    style('\t');
                }


                nextIndex++;
                nextIndex++;
            } else {

                for (int j = 0; j < (1 << height); j++) {
                    style('\t');
                }
                System.out.print(node);
                newNodes[nextIndex++] = node.left;
                newNodes[nextIndex++] = node.right;

                for (int j = 0; j < (1 << height); j++) {
                    style('\t');

                }

            }

        }
        System.out.println();


        if (checkAllNull(newNodes)) {
            return;
        }

        printNextLine0('|', nodes.length, height, nodes, newNodes);

        System.out.println();

        printNextLine1('-', nodes.length, height, nodes, newNodes);

        System.out.println();

//        printNextLine2('|', nodes.length, height, nodes, newNodes);


//        System.out.println();


        show1(newNodes, ++depth, --height);
    }

    private void printNextLine0(char c, int length, int height, Node<T>[] nodes, Node[] newNodes) {
        for (int start = 0; start < length; start++) {

            for (int i = 0; i < (1 << height) ; i++) {
                style('\t');
            }

            if (nodes[start] == null || (newNodes[2 * start + 0] == null && newNodes[2 * start + 1] == null)) {
                for (int j = 0; j < (1 << height) - 1; j++) {
                    for (int i = 0; i < 4; i++) {
                        style(' ');
                    }
                }

                System.out.print(' ' + "\t");
            } else {
                System.out.print(c + "\t");
                for (int j = 0; j < (1 << height) - 1; j++) {
                    for (int i = 0; i < 4; i++) {
                        style(' ');
                    }
                }
            }

        }
    }

    private void printNextLine(char c, int length, int height) {


        for (int start = 0; start < length; start++) {

            for (int i = 0; i < (1 << height) / 2; i++) {
                style('\t');
//                System.out.print(" ");
            }

//            System.out.print(c);


            for (int j = 0; j < (1 << height); j++) {
//                System.out.print("-");
                for (int i = 0; i < 4; i++) {
                    style(c);
                }
            }

//            System.out.print(c);
//            System.out.print(c);

            System.out.print(c + "\t");
//            System.out.print("\t");
            for (int z = 0; z < (1 << height) / 2 - 1; z++) {
                style('\t');
            }

        }
    }

    private void printNextLine1(char c, int length, int height, Node[] nodes, Node[] newNodes) {
        for (int start = 0; start < length; start++) {
            for (int i = 0; i < (1 << height) / 2; i++) {
                style('\t');
            }

            if (nodes[start] == null || (newNodes[2 * start + 0] == null && newNodes[2 * start + 1] == null)) {
                for (int j = 0; j < (1 << height); j++) {
                    for (int i = 0; i < 4; i++) {
                        style(' ');
                    }
                }

                System.out.print(' ' + "\t");
            } else if (newNodes[2 * start + 0] == null && newNodes[2 * start + 1] != null) {

                for (int j = 0; j < (1 << height) / 2; j++) {
//                    for (int i = 0; i < 4; i++) {
//                        style(' ');
//                    }
                    style('\t');
                }

                for (int j = 0; j < (1 << height) / 2; j++) {
                    for (int i = 0; i < 4; i++) {
                        style(c);
                    }
                }

                System.out.print(c + "\t");

            } else if (newNodes[2 * start + 0] != null && newNodes[2 * start + 1] == null) {
                for (int j = 0; j < (1 << height) / 2; j++) {
                    for (int i = 0; i < 4; i++) {
                        style(c);
                    }
                }
                System.out.print(c + "\t");

                for (int j = 0; j < (1 << height) / 2 - 1; j++) {
//                    for (int i = 0; i < 4; i++) {
//                        style(' ');
//                    }
                    style('\t');
                }

                style('\t');

            } else {
                for (int j = 0; j < (1 << height); j++) {
                    for (int i = 0; i < 4; i++) {
                        style(c);
                    }
                }
                System.out.print(c + "\t");
            }

            for (int z = 0; z < (1 << height) / 2 - 1; z++) {
                style('\t');
            }

        }
    }

    private boolean checkAllNull(Node<T>[] nodes) {

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null) return false;
        }
        return true;
    }

    public void remove(T element, Node<T> root) {


        if(root.left != null && root.left.element == element) {
            root.left = null;
            return;
        }

        if(root.right != null && root.right.element == element) {
            root.right = null;
            return;
        }

        if(root.left != null && root.left != element) {
            remove(element, root.left);
        }

        if(root.right != null && root.right != element) {
            remove(element, root.right);
        }


    }

    /**
     * 需求：
     * 如果删除的结点是叶子结点 直接删除
     *
     * 如果删除的结点是非叶子结点
     * 1. 该结点仅有一个子结点 ，使用该结点的子结点 替换该结点
     * 2. 该结点有两个子结点， 使用该结点的左结点 替换该结点
     *
     * @param element
     * @param root
     */
    public void remove1(T element, Node<T> root) {


        if(root.left != null && root.left.element == element) {

            if(root.left.left == null && root.left.right == null) {
                root.left = null;
            }else if(root.left.left != null && root.left.right != null) {
                root.left = root.left.left;
            }else if(root.left.left != null) {
                root.left = root.left.left;
            }else {
                root.left = root.left.right;
            }
            return;
        }

        if(root.right != null && root.right.element == element) {
            if(root.right.left == null && root.right.right == null) {
                root.right = null;
            }else if(root.right.left != null && root.right.right != null) {
                root.right = root.right.left;
            }else if(root.right.left != null) {
                root.right = root.right.left;
            }else {
                root.right = root.right.right;
            }
            return;
        }

        if(root.left != null && root.left != element) {
            remove1(element, root.left);
        }

        if(root.right != null && root.right != element) {
            remove1(element, root.right);
        }


    }

    public Node[] storageArray(Node<T> root) {
        System.out.println("size: " + size);

        int height = height(this.root);
        System.out.println("height: " + height);

        int length = (1 << (height + 1)) - 1;
        System.out.println("length: " + length);
        arrayTree = new Node[length];


        int i = 0;

        LinkedList<Node<T>> nodes = new LinkedList<>();
        nodes.add(root);
        while (! nodes.isEmpty()) {
            Node<T> tNode = nodes.removeFirst();
            arrayTree[i++] = tNode;

            if(i == length) break;

            if(tNode == null) {
                nodes.add(null);
                nodes.add(null);
            }else {

                nodes.add(tNode.left);
                nodes.add(tNode.right);
            }
        }

        return arrayTree;

    }

    public Node<T> convertArray2Tree(Node<T>[] nodes,  int i) {


        T element = nodes[i].element;
        Node<T> node = new Node<>(element, null, null);

        if(2 * i + 1 < nodes.length && nodes[2 * i + 1] != null) {
            node.left = convertArray2Tree(nodes, 2 * i + 1);
        }

        if(2 * i + 2 < nodes.length && nodes[2 * i + 2] != null) {
            node.right = convertArray2Tree(nodes, 2 * i + 2);
        }

        return node;
    }


    public static class Node<T> {
        private T element;
        private Node<T> left;
        private Node<T> right;

        public Node(T element, Node<T> left, Node<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        public Node(T element) {
            this(element, null, null);
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }


    private Node<T> root;


    public Tree() {
    }


    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public Node<T> insert(T element, Node<T> node) {

        if (node == null) {
            size++;
            return new Node<T>(element, null, null);
        }

        int i = element.compareTo(node.element);
        if (i < 0)
            node.left = insert(element, node.left);
        else if (i > 0)
            node.right = insert(element, node.right);
        else
            ;
        return node;
    }


    public boolean contains(T element, Node<T> node) {
        if (node == null) {
            return false;
        }

        int i = element.compareTo(node.element);
        if (i < 0) {
            return contains(element, node.left);
        } else if (i > 0) {
            return contains(element, node.right);
        } else
            return true;

    }


    public void preOrder(Node<T> node) {
        System.out.println(node);

        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }
}
