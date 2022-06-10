package com.wx.recursion;

public class Demo {
    public static void main(String[] args) {

        int n = 10;
        int result =  f(n);
        System.out.println(n + "! = " + result);

        System.out.printf("%d! = %d\n", n, result);

        int k = 423;
        f1(k);

        f1_loop(k, 3);

    }

    private static void f1_loop(int k, int size) {

//        123 / 100 % 10  123 / 10 / 10; 123 % 10
                /*
                2 0
                1 1
                0 2
                size- 1
                 */

        for (int i = 0; i < size; i++) {
             int r = (int)(k / Math.pow(10, size - 1 - i) % 10);
            System.out.println(r);
        }
    }

    private static void f1(int k) {  

       if(k > 9) {
            f1(k / 10);
       }

       System.out.println(k % 10);

    }



    private static int f(int n) {
    /*    if(n == 1) return 1;
        return n * f(n - 1);*/

        return n == 1 ? 1 : n * f(n - 1);
    }
}
