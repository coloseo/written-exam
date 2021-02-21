package com.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test2 {


    public static void main(String[] args) {
        List signs = new ArrayList();
        signs.add("+");
        signs.add("-");
        signs.add("*");
        signs.add("/");
        String[] arr = {"4","13","5","/","+"};
        Stack<String> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            String item = arr[i];
            if (!signs.contains(item)) {
                stack.push(item);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if (item.equals("+")) {
                    stack.push((num1 + num2) + "");
                } else if (item.equals("-")) {
                    stack.push((num2 - num1) + "");
                } else if (item.equals("*")) {
                    stack.push((num1 * num2) + "");
                } else {
                    stack.push((num2 / num1) + "");
                }
            }
        }
        System.out.println(stack.pop());
    }
}
