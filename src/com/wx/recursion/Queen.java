package com.wx.recursion;

import java.util.Arrays;

public class Queen {

    private static int count = 0;

    public static void main(String[] args) {


        int[] result = new int[8];

        queen8(result);

    }

    private static void queen8(int[] result) {

        start(0, result);

        System.out.println("count: " +count);

    }

    private static void start(int i, int[] result) {

        if(i == result.length) {
            System.out.println(Arrays.toString(result));
            count++;
            return;
        }

        for (int j = 0; j < result.length; j++) {

            result[i] = j;
            if(! conflict(i, result)) {
                start(i+1, result);
            }

        }
    }

    private static boolean conflict(int i, int[] result) {
        for (int j = 0; j < i; j++) {
            if(result[j] == result[i] || Math.abs(i - j) == Math.abs(result[i] - result[j])) {
                return true;
            }
        }
        return false;
    }
}
