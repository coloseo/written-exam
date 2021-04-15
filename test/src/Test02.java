import java.util.Stack;

public class Test02 {
    //编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *

    //判断是否为+-/*
    private static boolean isOperator(String token){
        //return "+-*/".indexOf(token) != -1;
        return "+-*/".contains(token);
    }
    //计算结果
    private static int calculate(Integer left,Integer right,String operator){
        switch (operator){
            case "+":return left + right;
            case "-":return left - right;
            case "*":return left * right;
            default:return left / right;
        }
    }
    //逆波兰表示法
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();//栈
        for (String token : tokens) {
            if(isOperator(token)){//运算符
                Integer left = stack.pop();
                Integer right =  stack.pop();
                stack.push(calculate(left,right,token));
            }else {//数字
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "3", "4", "+", "*"};
        System.out.println(evalRPN(tokens));
    }
}

