package com.wx.recursion;

public class MiGong {
    public static void main(String[] args) {

        int[][] map = new int[8][7];

        createGraph(map);

        showGraph(map);


        //走迷宫
        setWay(map, 1, 1);
        System.out.println();

        showGraph(map);

    }

    public static boolean setWay(int[][] map, int i, int j) {

        if(map[1][3] == 2) return true;

        if(map[i][j] == 0) {
            map[i][j] = 2;

            if(setWay(map, i + 1, j)) {
                return true;
            }else if(setWay(map, i, j + 1)) {
                return true;
            }else if(setWay(map, i-1, j)) {
                return true;
            }else if(setWay(map, i, j - 1)) {
                return true;
            }else {
                map[i][j] = 3;
                return false;
            }
        }else {
            return false;
        }

    }
    public static boolean setWay1(int[][] map, int i, int j, int g, int k) {

        if(map[g][k] == 2) return true;

//        System.out.println("i,j:" + i +" " + j);
        if(map[i][j] == 0) {
            map[i][j] = 2;

            if(setWay1(map, i + 1, j, g, k)) {
                return true;
            }else if(setWay1(map, i, j + 1, g, k)) {
                return true;
            }else if(setWay1(map, i-1, j, g, k)) {
                return true;
            }else if(setWay1(map, i, j - 1, g, k)) {
                return true;
            }else {
                map[i][j] = 3;
                return false;
            }
        }else {
            return false;
        }

    }

    public static void showGraph(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] +"\t");
            }
            System.out.println();
        }
    }

    public static void createGraph(int[][] map) {

        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
    }

    public static void createGraph88(int[][] map) {



    }

    public static void createGraph_16x16(int[][] map) {

        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[map.length - 1][i] = 1;
        }

        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][map[0].length - 1] = 1;
        }

        //entry
        map[1][0] = 0;

        //exit
        map[15][15] = 0;

        map[1][7] = 1;

        for (int i = 0; i < 16; i++) {
            map[2][i] = 1;
        }
        map[2][2] = 0;
        map[2][6] = 0;
        map[2][8] = 0;
        map[2][14] = 0;

        map[3][3] = 1;
        map[3][7] = 1;
        map[3][13] = 1;

        for (int i = 0; i < 16; i++) {
            map[4][i] = 1;
        }
        map[4][1] = 0;
        map[4][12] = 0;
        map[4][14] = 0;

        map[5][5] = 1;
        map[5][9] = 1;
        map[5][13] = 1;

        for (int i = 0; i < 16 ; i++) {
            map[6][i] = 1;
        }
        map[6][1] = 0;
        map[6][4] = 0;
        map[6][8] = 0;
        map[6][14] = 0;

        map[7][3] = 1;

        for (int i = 0; i < 16; i++) {
            map[8][i] = 1;
        }
        map[8][2] = 0;
        map[8][6] = 0;

        map[9][3] = 1;
        map[9][5] = 1;

        for (int i = 0; i < 16; i++) {
            map[10][i] = 1;
        }
        map[10][1] = 0;
        map[10][4] = 0;
        map[10][6] = 0;
        map[10][8] = 0;
        map[10][14] = 0;

        map[11][5] = 1;
        map[11][7] = 1;
        map[11][13] = 1;

        for (int i = 0; i < 16; i++) {
            map[12][i] = 1;
        }
        map[12][6] = 0;
        map[12][12] = 0;
        map[12][14] = 0;

        map[13][7] = 1;
        map[13][11] = 1;
        map[13][13] = 1;


        for (int i = 0; i < 16; i++) {
            map[14][i] = 1;
        }
        map[14][1] = 0;
        map[14][8] = 0;
        map[14][10] = 0;
        map[14][12] = 0;

        map[15][9] = 1;
        map[15][11] = 1;


    }
}
