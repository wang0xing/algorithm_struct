package com.wx.binary_tree.example;

import com.wx.binary_tree.Tree;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        Hero songJiang = new Hero(1, "SongJiang");
        Hero luJunYi = new Hero(2, "LuJunYi");
        Hero wuYong = new Hero(3, "WuYong");
        Hero gongSunSheng = new Hero(4, "GongSunSheng");
        Hero guanSheng = new Hero(5, "GuanSheng");
        Hero liChong = new Hero(6, "LiChong");
        Hero qinMing = new Hero(7, "QinMing");

        Tree<Hero> heroTree = new Tree<>();
        Tree.Node<Hero> root = heroTree.insert(gongSunSheng, null);
        heroTree.setRoot(root);

        heroTree.insert(luJunYi, root);
        heroTree.insert(songJiang, root);
        heroTree.insert(wuYong, root);

        heroTree.insert(qinMing, root);
        heroTree.insert(liChong, root);
        heroTree.insert(guanSheng, root);


        heroTree.show1(new Tree.Node[]{root}, 0, heroTree.height(root));

//        heroTree.remove(guanSheng, heroTree.getRoot());

//        heroTree.show1(new Tree.Node[]{root}, 0, heroTree.height(root));

//        heroTree.remove1(guanSheng, root);
//        heroTree.remove1(liChong, root);

//        heroTree.remove1(luJunYi, root);

//        heroTree.remove1(songJiang, root);
//        heroTree.show1(new Tree.Node[]{root}, 0, heroTree.height(root));

        Tree.Node<Hero>[] nodes = heroTree.storageArray(root);
        System.out.println(Arrays.toString(nodes));

        Tree.Node newRoot =  heroTree.convertArray2Tree(nodes, 0);

        heroTree.show1(new Tree.Node[]{newRoot}, 0, heroTree.height(newRoot));

    }
}
