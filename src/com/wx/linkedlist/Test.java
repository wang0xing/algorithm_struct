package com.wx.linkedlist;

public class Test {
    public static void main(String[] args) {

        LinkedList heroLinkedList = new LinkedList();

        heroLinkedList.add(new HeroNode(1, "宋江", "及时雨"));
        heroLinkedList.add(new HeroNode(2, "卢俊义", "玉麒麟"));
        heroLinkedList.add(new HeroNode(3, "吴用", "智多星"));
        heroLinkedList.add(new HeroNode(4, "公孙胜", "入云龙"));
        heroLinkedList.add(new HeroNode(5, "关胜", "大刀"));

        heroLinkedList.printLinkedList();

        HeroNode linChong = new HeroNode(6, "林冲", "豹子头");
        heroLinkedList.add(linChong);

        heroLinkedList.printLinkedList();
        System.out.println("删除 宋江: " + heroLinkedList.remove());
        heroLinkedList.printLinkedList();
        HeroNode qinMing = new HeroNode(7, "秦明", "霹雳火");
        heroLinkedList.add(0, qinMing);
        heroLinkedList.printLinkedList();


        Object remove = heroLinkedList.remove(1);
        System.out.println(remove);

        heroLinkedList.printLinkedList();

//        Object remove1 = heroLinkedList.remove(5);
//        System.out.println(remove1);

//        heroLinkedList.update(1, qinMing);

        heroLinkedList.update(1, qinMing);
        heroLinkedList.printLinkedList();

        Object o = heroLinkedList.get(1);
        System.out.println(o);
        System.out.println(heroLinkedList);
        System.out.println(heroLinkedList.size());

        Object reverse = heroLinkedList.getReverse(1);
        System.out.println("倒数 1: " + reverse);


        System.out.println("-----------------------");

        heroLinkedList.printLinkedList();
        heroLinkedList.reverse();

        heroLinkedList.printLinkedList();
        heroLinkedList.printReverseList();

        heroLinkedList.printReverseList1();

        int[] arr0 = {2, 4, 5};
        int[] arr1 = {1, 3, 6};

        LinkedList list0 = new LinkedList();
        LinkedList list1 = new LinkedList();

        for (int i = 0; i < arr0.length; i++) {
            list0.add(arr0[i]);
        }

        for (int i = 0; i < arr1.length; i++) {
            list1.add(arr1[i]);
        }

        list0.combine(list1);

    }
}
