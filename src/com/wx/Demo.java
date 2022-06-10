package com.wx;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        int[] arr = {4, -1, 2, 3, 7};

        System.out.println("origin arr " + Arrays.toString(arr));
        int max = getMax(arr, 5);
        System.out.println("max = " + max);

        System.out.println("-------------------");
        int max1 = getMax1(arr, 2);
        System.out.println("max1 = " + max1);
        System.out.println("arr = " + Arrays.toString(arr));

    }

    private static int getMax1(int[] arr, int k) {

        int temp;
        //对arr进行冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] < arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }


        return arr[k-1];
    }

    private static int getMax(int[] arr, int k) {

        if(k > arr.length || k < 0) {
            throw new RuntimeException("k 不合法");
        }

        if(k == 1) {
            return arr[0];
        }

        int max;
        for (int i = 0; i < k - 1; i++) {
            if(arr[i] > arr[i + 1]) {

                //swap
                max = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = max;

//                System.out.println(Arrays.toString(arr));
            }
        }

        return arr[k - 1];
    }


}
