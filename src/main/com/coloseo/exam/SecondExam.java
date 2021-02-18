package com.coloseo.exam;

/**
 * leetCode NO 150 逆波兰表达式
 */
public class SecondExam {
    public static int evalRPN(String[] tokens) {
        int[] numStack = new int[tokens.length / 2 + 1];
        int index = 0;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    numStack[index - 2] += numStack[--index];
                    break;
                case "-":
                    numStack[index - 2] -= numStack[--index];
                    break;
                case "*":
                    numStack[index - 2] *= numStack[--index];
                    break;
                case "/":
                    numStack[index - 2] /= numStack[--index];
                    break;
                default:
                    numStack[index++] = Integer.parseInt(s);
                    break;
            }
        }
        return numStack[0];
    }

    public static void main(String[] args) {
         String[] strings={"2","1","+","3","*"};
        int i = evalRPN(strings);
        System.out.println(i);
    }

}
