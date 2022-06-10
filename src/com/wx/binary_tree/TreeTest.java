package com.wx.binary_tree;

public class TreeTest {

    public static void main(String[] args) {
        
        Tree<Integer> integerTree = new Tree<>();

        Tree.Node<Integer> insert = integerTree.insert(6, null);
        integerTree.setRoot(insert);

        integerTree.insert(8, integerTree.getRoot());
        integerTree.insert(2, integerTree.getRoot());
        integerTree.insert(1, integerTree.getRoot());
        integerTree.insert(4, integerTree.getRoot());
        integerTree.insert(3, integerTree.getRoot());
//
//
        integerTree.insert(5, integerTree.getRoot());
        integerTree.insert(9, integerTree.getRoot());
        integerTree.insert(10, integerTree.getRoot());

        integerTree.insert(7, integerTree.getRoot());

        integerTree.insert(0, integerTree.getRoot());

//        integerTree.insert(-1, integerTree.getRoot());

        Tree.Node<Integer>[] nodes = new Tree.Node[1];
        nodes[0] = integerTree.getRoot();

        System.out.println("height : " + integerTree.height(integerTree.getRoot()));
        integerTree.show1(nodes, 0, integerTree.height(integerTree.getRoot()));


//        System.out.println("pre order");
//        integerTree.preOrder(integerTree.getRoot());
//
//
//        System.out.println("infix order");
//        integerTree.infixOrder(integerTree.getRoot());


        
    }
}
