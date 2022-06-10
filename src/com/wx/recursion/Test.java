package com.wx.recursion;

public class Test {
    public static void main(String[] args) {


        //创建一个8*8迷宫
        int rows = 17;
        int cols = 16;
        int[][] map = new int[17][16];

        MiGong.createGraph_16x16(map);

        MiGong.showGraph(map);
        System.out.println("----------------------------------");

        MiGong.setWay1(map, 1, 0, 15, 15);

        MiGong.showGraph(map);




    }
}
