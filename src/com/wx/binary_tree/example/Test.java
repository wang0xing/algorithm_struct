package com.wx.binary_tree.example;

import com.wx.binary_tree.Tree;

public class Test {
    public static void main(String[] args) {

        Hero songJiang = new Hero(1, "SongJiang");
        Hero luJunYi = new Hero(2, "LuJunYi");
        Hero wuYong = new Hero(3, "WuYong");
        Hero gongSunSheng = new Hero(4, "GongSunSheng");
        Hero guanSheng = new Hero(5, "GuanSheng");

        Tree<Hero> heroTree = new Tree<>();
        Tree.Node<Hero> root = heroTree.insert(wuYong, null);
        heroTree.setRoot(root);

        heroTree.insert(luJunYi, root);
        heroTree.insert(songJiang, root);
        heroTree.insert(gongSunSheng, root);
        heroTree.insert(guanSheng, root);


        heroTree.show1(new Tree.Node[]{root}, 0, heroTree.height(root));


    }
}
