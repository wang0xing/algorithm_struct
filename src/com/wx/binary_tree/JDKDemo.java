package com.wx.binary_tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class JDKDemo {
    public static void main(String[] args) {

        TreeSet<Integer> integers = new TreeSet<>();

        for (int i = 0; i < 10; i++) {
            integers.add(i + 1);
        }

        integers.add(1);

        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();

        System.out.println(integers);

        TreeSet<String> strings = new TreeSet<>();
        strings.add("123");
        strings.add("aa");
        strings.add("bb");

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

        TreeSet<MyObject> myObjects = new TreeSet<>();
        myObjects.add(new MyObject(1, "1"));
        myObjects.add(new MyObject(0, "3"));
        myObjects.add(new MyObject(1, "2"));
        myObjects.add(new MyObject(1, "3"));
        myObjects.add(new MyObject(1, "3"));
        myObjects.add(null);

        Iterator<MyObject> iterator1 = myObjects.iterator();
        while (iterator1.hasNext()) {
            MyObject next = iterator1.next();
            System.out.println(next);
        }

    }
}
