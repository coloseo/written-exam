package com.exam;

public class test01 {

    public static void main(String[] args) {

        String s ="woshizifuchuanS";
        String s1 = reverse(s);
        System.out.println(s1);

    }
    private static String reverse(String s) {

        if (s == null || s.length() < 2) {
            return s;
        } else {
            System.out.print(s.substring(s.length() - 1));
            return reverse(s.substring(0, s.length()-1));
        }
    }

}
