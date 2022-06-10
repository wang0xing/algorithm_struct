package com.wx.stack;

import java.util.*;

public class Demo {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        String expression = "6 + 4 * 5 + 10"; //result 6+20-3=23

        expression = "3 / 6 * 2 + 5";

        expression = "6 * ( 2 + 1 ) + 1";

        expression = "6 * ( 1 - 1 * 5 + 2 ) + 1";

        expression = "( 2 + 1 ) * 3 - 1";

       int result =  calculator.calc(expression);

        System.out.println("result = " + result);

        Scanner scanner = new Scanner(System.in);

        String[] strings = {"12", "10", "8", "2"};
        int i = 0;
        while (scanner.hasNext()) {

            String s1 = scanner.nextLine();

            strings =  s1.split(" ");
            while (true) {

                String s = generateExpression(strings);
                System.out.println("s = " +s);
                int calc = calculator.calc(s);
                System.out.println("calc = " + calc);

                if(calc == 24) {
                    System.out.println("result s = " + s);
                    break;
                }

            }


        }

    }

    private static String generateExpression(String[] strings) {

        //4 2 3 1
        StringBuilder s1 = new StringBuilder();

//        String[] strings = {"2", "3", "4", "1"};
        String[] ope = {"+", "-", "*", "/"};



//        List<String> stringList = Arrays.asList(strings);

        List<String> stringList = new ArrayList<>();

        for (String string : strings) {
            stringList.add(string);
        }

//        System.out.println(list.remove(3));

        Random random = new Random();
        int size = 4;



        String remove = stringList.remove(random.nextInt(size--));
        s1.append(remove);
        s1.append(" ");

        s1.append(ope[random.nextInt(4)]);
        s1.append(" ");

        String remove1 = stringList.remove(random.nextInt(size--));
        s1.append(remove1);
        s1.append(" ");

        s1.append(ope[random.nextInt(4)]);
        s1.append(" ");

        String remove2 = stringList.remove(random.nextInt(size--));
        s1.append(remove2);
        s1.append(" ");

        s1.append(ope[random.nextInt(4)]);
        s1.append(" ");

        String remove3 = stringList.remove(random.nextInt(size--));
        s1.append(remove3);
        s1.append(" ");

        return s1.toString();
    }
}
