package com.greathzeze;

/**
 * @Description:
 * 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
 * @Date: 2021/2/27 17:58
 * @Author: Greathzeze
 */
public class ReverseStr {

    public static char[] reverseStr(char[] chars,int length){

        if(length >1){
            for (int i = 0; i < length -1; i++) {
                char temp = chars[i];
                chars[i] = chars[i+1];
                chars[i+1] = temp;
            }
            length--;
            reverseStr(chars,length);
        }
        return chars;
    }

    public static void main(String[] args) {
        char[] chars = "123".toCharArray();
        System.out.println(reverseStr(chars,chars.length));
    }
}
