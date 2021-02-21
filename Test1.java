package com.study;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(reverse("abcd"));
    }

    public static String reverse(String s) {
        if (s == null) {
            return null;
        }
        if (s.isEmpty()) {
            return s;
        }

        StringBuilder result = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
