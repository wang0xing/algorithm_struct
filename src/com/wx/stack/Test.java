package com.wx.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

  /*      int i = Integer.parseInt("123");
        System.out.println(i);

        int i1 = Integer.parseInt("+");
        System.out.println(i1);*/


      /*  String s1 = "1231";
        String[] split = s1.split("");
        List<String> stringList = Arrays.asList(split);
        System.out.println(stringList);



        testConvertSuffix();*/

        System.out.println(1 / 0);
        int[] arr = {2, 3, 4, 1};
        RandomNumber randomNumber = new RandomNumber();


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            for (int i = 0; i < s1.length; i++) {
                arr[i] = Integer.parseInt(s1[i]);
            }

            ArrayList<int[]> ints = randomNumber.combine4Num(arr);
            List<String> allCombine = randomNumber.getAllCombine(ints);

            List<String> match24Result = randomNumber.getMatch24Result(allCombine);

            if(match24Result.size() > 7) {
                for (int i = 0; i < 7; i++) {
                    System.out.println(match24Result.get(i));
                }
            }else {
                match24Result.forEach(System.out::println);
            }
        }


    }

    private static void testConvertSuffix() {

        Calculator calculator = new Calculator();
        String expression = "6+4*5-3";


    }
}
