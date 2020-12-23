package com.keluo.expr;

import java.util.Scanner;
import java.util.Stack;

public class SumExpr {
	public static void main(String[] args) {
		System.out.println("请输入的逆波兰表达式（空值回车默认2 3 4 + *）: ");
		Scanner sc = new Scanner(System.in);
		String expr = "2 3 4 + *";
		String nextLine = sc.nextLine();
		expr = nextLine != null ?!"".equals(nextLine)?nextLine:expr:expr;
		System.out.println(expr+"表达式的结果是: "+sumExpr(expr));
	}

	private static long sumExpr(String expr) {
		Stack<String> st = new Stack<String>();
		long sum_num = 0;
		String[] expr_split = expr.split(" ");
		for(String str : expr_split) {
			//先判断不是符号加入栈中，是则先取出运算符的第一个操作数，再取出第二个操作数根据运算符运算后将结果作为第一个操作数push到栈中
			switch(str) {
				case "+": sum_num = Long.valueOf(st.pop()); sum_num = sum_num + Long.valueOf(st.pop()); st.push(String.valueOf(sum_num)) ;break;
				case "-": sum_num = Long.valueOf(st.pop()); sum_num = sum_num - Long.valueOf(st.pop()); st.push(String.valueOf(sum_num)) ;break;
				case "*": sum_num = Long.valueOf(st.pop()); sum_num = sum_num * Long.valueOf(st.pop()); st.push(String.valueOf(sum_num)) ;break;
				case "/": sum_num = Long.valueOf(st.pop()); sum_num = sum_num / Long.valueOf(st.pop()); st.push(String.valueOf(sum_num)) ;break;
				default: st.push(str) ;break;
			}
		}
		return sum_num;
	}

}
