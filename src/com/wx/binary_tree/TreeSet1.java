package com.wx.binary_tree;

public class TreeSet1 {
    public static void main(String[] args) {

        Tree<String> stringTree = new Tree<>();
        Tree.Node<String> a = stringTree.insert("a", null);
        stringTree.setRoot(a);

        stringTree.insert("b", stringTree.getRoot());
        stringTree.insert("c", stringTree.getRoot());
        stringTree.insert("张三23423", stringTree.getRoot());
        stringTree.insert("aaaab", stringTree.getRoot());

        Tree.Node<String>[] nodes = new Tree.Node[1];

        nodes[0] = stringTree.getRoot();
        stringTree.show1(nodes, 0, stringTree.height(stringTree.getRoot()));


    }
}
