package com.tengxq.sort;

/**
 * xxx
 *
 * @author: tengxq
 * @since: 2021-03-11 17:57
 */
public class ReverseStrDemo {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdef"));
    }

    public static String reverseStr(String str){
        if (null == str || str.length() <= 1){
            return str;
        }
        return reverseStr(str.substring(1)) + str.charAt(0);
    }
}
