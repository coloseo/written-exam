package com.keluo.string;

import java.util.Scanner;

public class StringReverse {
	public static void main(String[] args) {
		System.out.println("请输入目标字符串(空值回车默认abcdeda):");
		Scanner sc = new Scanner(System.in);
		String str = "abcdeda";
		String nextLine = sc.nextLine();
		str = nextLine !=null? !"".equals(nextLine)? nextLine : str : str;
		System.out.println("倒叙后的字符串是: " + reverse(str));
	}

	private static String reverse(String str_resource) {
		char[] arr_str_resource = str_resource.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i = arr_str_resource.length - 1; i >= 0 ; i-- ) {
			sb.append(arr_str_resource[i]);
		}
		return sb.toString();
	}
}
