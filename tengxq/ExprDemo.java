package com.tengxq.sort;

import java.util.Stack;

/**
 * xxx
 *
 * @author: tengxq
 * @since: 2021-03-11 17:24
 */
public class ExprDemo {
    public static void main(String[] args) {
        String value = "234+*";
        System.out.println(exchangeExpressValue(value));
    }
    /**
     * 后缀转中缀表达式并求值（只支持加减乘除不带括号）
     *
     * 规则：
     *
     * 1.数字直接入队列
     * 2.运算符连续弹出两个栈顶元素进行计算，
     *
     *
     * @param
     * @return
     */
    public static int exchangeExpressValue(String value){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i <value.length() ;i++) {
            if ((value.charAt(i) + "").matches("\\d")){
                stack.push(value.charAt(i) + "");
            }else if ((value.charAt(i) + "").matches("[\\+\\-\\*\\/]")){
                if (stack.size() < 2){
                    throw new IllegalArgumentException("非法的表达式");
                }
                String a = stack.pop();
                String b = stack.pop();
                int c = calculate(a, b, (value.charAt(i) + ""));
                stack.push(c+"");
            }

        }
        return Integer.valueOf(stack.pop());
    }

    private static int calculate(String a, String b, String operator) {
        switch(operator){
            case "+":
                return Integer.valueOf(b)+Integer.valueOf(a);
            case "-":
                return Integer.valueOf(b)-Integer.valueOf(a);
            case "*":
                return Integer.valueOf(b)*Integer.valueOf(a);
            case "/":
                return Integer.valueOf(b)/Integer.valueOf(a);
            default:
                throw new IllegalArgumentException("不支持"+operator+"类型的运算符！");
        }
    }
}
