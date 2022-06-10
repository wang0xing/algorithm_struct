package com.wx.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Calculator {


    public int calc(String expression) {

        List<String> stringList = parseExpress(expression);

        List<String> suffixList = convertToSuffix(stringList);

        return calc0(suffixList);
    }

    private int calc0(List<String> stringList) {

        Stack<Integer> integers = new Stack<>();
        stringList.forEach(s -> {

            try {
                int i = Integer.parseInt(s);
                integers.push(i);

            } catch (NumberFormatException numberFormatException) {


                int param1 = integers.pop();
                int param2 = integers.pop();

                switch (s) {
                    case "+":
                        int sum = add(param1, param2);
                        integers.push(sum);
                        break;
                    case "-":
                        int sub = sub(param2, param1);
                        integers.push(sub);
                        break;
                    case "*":
                        int mul = mul(param1, param2);
                        integers.push(mul);
                        break;
                    case "/":
                        int divide = divide(param2, param1);
                        integers.push(divide);
                        break;
                    default:
                        throw new RuntimeException("运算符错误！");
                }

            }


        });

        return integers.pop();
    }

    private int add(Integer pop, Integer pop1) {
        return pop + pop1;
    }

    private int sub(Integer pop, Integer pop1) {
        return pop - pop1;
    }

    private int mul(Integer pop, Integer pop1) {
        return pop * pop1;
    }

    private int divide(Integer pop, Integer pop1) {
        if (pop1 == 0) throw new ArithmeticException("/ by zero");
        return pop / pop1;
    }

    public List<String> convertToSuffix1(List<String> stringList) {

        List<String> suffixList = new ArrayList<>();

        Stack<String> stack = new Stack<>();

        for (String s : stringList) {
            try {
                /*
                 * 如果是操作数 直接加入列表
                 */
                Integer.parseInt(s);
                suffixList.add(s);

            } catch (NumberFormatException e) {

                if (")".equals(s)) {
                    while (!"(".equals(stack.peek())) {
                        suffixList.add(stack.pop());
                    }
                    //pop '('
                    stack.pop();
                    continue;
                }

                if (!"(".equals(s)) {
                    while (!stack.isEmpty() && !"(".equals(stack.peek()) && priority(s) <= priority(stack.peek())) {
                        suffixList.add(stack.pop());
                    }
                }
                //当前操作符压栈
                stack.push(s);
            }

        }


        while (!stack.isEmpty()) {
            suffixList.add(stack.pop());
        }


        return suffixList;
    }

    public List<String> convertToSuffix(List<String> stringList) {

        List<String> suffixList = new ArrayList<>();

        Stack<String> stack = new Stack<>();

        for (String s : stringList) {
            try {
                /*
                 * 如果是操作数 直接加入列表
                 */
                Integer.parseInt(s);
                suffixList.add(s);

            } catch (NumberFormatException e) {

                //如果栈为空 直接入栈
                if (!stack.isEmpty()) {

                    //处理 ”)“ 情况
                    /*
                     * 1. 将栈中元素全程出栈 直到遇到”(“
                     * 2. 将”(“ 出栈
                     */
                    if (")".equals(s)) {
                        while (!"(".equals(stack.peek())) {
                            suffixList.add(stack.pop());
                        }

                        //pop '('
                        stack.pop();

                        continue;

                    }


                    /*
                     * 当前的操作符与栈顶的运算符比较优先级
                     * 要同时满足三个条件
                     * 1. 当前操作符不是 (
                     * 2. 栈顶操作符不是 (
                     * 3. 当前操作符优先级不大于栈顶操作符优先级
                     */
                    if (!"(".equals(s) && !"(".equals(stack.peek()) && priority(s) <= priority(stack.peek())) {

                        while (!stack.isEmpty() && !"(".equals(stack.peek()) && priority(s) <= priority(stack.peek())) {
                            String pop = stack.pop();
                            suffixList.add(pop);
                        }

                    }

                }

                //当前操作符压栈
                stack.push(s);
            }


        }

        while (!stack.isEmpty()) {
            suffixList.add(stack.pop());
        }


        return suffixList;
    }


    private int priority(String currentOperator) {
        int level;
        switch (currentOperator) {
            case "+":
            case "-":
                level = 1;
                break;
            case "*":
            case "/":
                level = 2;
                break;
            default:
                throw new RuntimeException("不支持的运算符");
        }

        return level;
    }

    /**
     * 将运算表达式解析成为操作数列表
     *
     * @param expression 运算表达式
     * @return 操作数列表
     */
    public List<String> parseExpress(String expression) {
        return Arrays.asList(expression.split(" "));
    }
}
