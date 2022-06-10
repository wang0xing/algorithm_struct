package com.wx.stack;

import java.util.List;
import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {


        String expression = "6 * ( ( 2 + 3 ) - 5 )";
        expression = "9 + ( 3 - 1 ) * 3 + 10 / 2";
        expression = "( 2 + 1 * 5 ) / 7";
        Calculator calculator = new Calculator();
//        int calc = calculator.calc(expression);
//        System.out.println(calc);

        List<String> stringList = calculator.parseExpress(expression);
        System.out.println(stringList);

        List<String> stringList1 = calculator.convertToSuffix1(stringList);
        System.out.println(stringList1);

        System.out.println(calculator.calc(expression));

    }
}
