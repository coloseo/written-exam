package com.itxs.coloseo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *
 * 使用栈的存储结构来解决问题，后缀表达式 2*(3+4)=14
 * @author it小帅
 * @version 1.0
 * @datetime 2021/3/15 16:30
 */
public class SecondQuestion {
    public static void main(String[] args) {
        String str="expr 2 3 4 + *";
        List<String> string = getListString(str);
        int expr = expr(string);
        System.out.println(expr);
    }

    /**
     * 将我们的命令行输入的逆波兰表达式转成一个list，表达式进行一个一个的扫描但是太慢了
     * @param str
     * @return
     */
    public static List<String> getListString(String str){
        List<String> list=new ArrayList<String>();
        //我们创建一个数组，里面用来存我们的操作数和运算符
        String[] spilt=str.split(" ");
        for (String s : spilt) {
            list.add(s);
        }
        return list;
    }

    /**
     * 计算一个表达式的值
     * @param expression 表达式
     */
    public static int expr(List<String> expression){
        //先判断用户输入的表达式是否有问题，有问题就直接返回-1
        if (expression.contains("expr")){
            //创建一个栈的存储结构
            expression.remove("expr");
                //使用java中本身存在的stack
                //创建栈Stack，这里我们只需要一个栈就可以了
                Stack<String> stack = new Stack<String>();
                //遍历我们传入的list
                for (String item : expression) {
                    //这里使用正则表达式来取出数
                    if (item.matches("\\d+")) {//可以匹配多位数
                        //入栈
                        stack.push(item);
                    } else {//就说明我们拿到list集合中的操作符，我们就弹出两个数进行运算
                        int num1 = Integer.valueOf(stack.pop());
                        int num2 = Integer.valueOf(stack.pop());
                        int res = 0;
                        switch (item) {
                            case "*":
                                res = num1 * num2;
                                break;
                            case "/":
                                res = num2 / num1;
                                break;
                            case "+":
                                res = num1 + num2;
                                break;
                            case "-":
                                res = num2 - num1;
                                break;
                            default:
                                throw new RuntimeException("此操作符暂时不支持");
                        }
                        stack.push(res + "");

                    }
                }
                return Integer.valueOf(stack.pop());
        }else{
            return -1;
        }
    }



}
