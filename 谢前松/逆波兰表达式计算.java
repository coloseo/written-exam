package pers.xqs.algorithm;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.Pattern;

public class 逆波兰表达式计算 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (!"quit".equals(line)) {
            String[] strings = line.split("\\s");
            if ("expr".equals(strings[0])) {
                String[] exprs = Arrays.copyOfRange(strings, 1, strings.length);
                System.out.println(expr(exprs));
            } else {
                System.out.println("不支持该指令,请重新输入,输入quit退出!");
            }
            line = sc.nextLine();
        }
    }

    public static Double expr(String[] expr) {
        //先检测输入是否为逆波兰表达式，先存数字到数字栈，然后存运算符到运算符队列
        //必定是数字在前，运算符在后，同时满足数字栈长度等于运算符队列长度+1
        Stack<Double> mathStack = new Stack<>(); //存储数字
        Queue<String> signQueue = new LinkedList<String>(); //存储运算符
        Boolean tag = true; //表示正在存入数字，否则为
        for (String s : expr) {
            if (isInteger(s) && tag) {
                mathStack.push(Double.valueOf(s));
            } else if (isSign(s)) {
                tag = false; //表示开始存储运算符
                signQueue.add(s);
            } else {
                return null;//输入有误
            }
        }
        if (mathStack.size() != signQueue.size() + 1) return null;//输入有误

        //开始计算
        while (!signQueue.isEmpty()) {
            String sign = signQueue.remove();
            Double num2 = mathStack.pop();
            Double num1 = mathStack.pop();
            if ("+".equals(sign)) {
                mathStack.push(num1 + num2);
            } else if ("-".equals(sign)) {
                mathStack.push(num1 - num2);
            } else if ("*".equals(sign)) {
                mathStack.push(num1 * num2);
            } else if ("/".equals(sign)) {
                mathStack.push(num1 / num2);
            }

        }
        return mathStack.pop(); //最后栈顶即为最终结果
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");
        return pattern.matcher(str).matches();
    }

    public static boolean isSign(String str) {
        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
    }

}
