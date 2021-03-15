package com.itxs.coloseo;




/**
 * 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
 * 反转字符串
 * 就是是将字符串转成字符数组，数组中首位进行交换使用递归实现
 * @author it小帅
 * @version 1.0
 * @datetime 2021/3/15 15:19
 */
public class FirstQuestion {
    public static void main(String[] args){
        String str="abc";
        String result = reverseString(str);
        System.out.println(result);
    }

    /**
     * 递归反转字符串，将一个字符串进行反转
     * @param str
     * @return
     */
    public static String reverseString(String str){
        if (str!=null&&str.length()>0) {
            char[] arr = str.toCharArray();
            int length = arr.length-1;
             reverse(arr,0,length);
             return String.valueOf(arr);
        }else{
            return null;
        }
    }

    public static void reverse(char[] arr,int start,int end){
        if (end-start>2){
            reverse(arr,start+1,end-1);
        }
        char temp;
        temp = arr[end];
        arr[end]=arr[start];
        arr[start]=temp;
    }


//    /**
//     * 非递归反转字符串，将一个字符串进行反转
//     * @param str
//     */
//    public static String reverse(String str){
//        //首先判断传进来的字符串不是“”
//        if (str!=null&&!"".equals(str)){
//            char[] chars = str.toCharArray();
//            for (int i=0;i< chars.length/2;i++){
//                char temp=chars[i];
//                chars[i]=chars[chars.length-i-1];
//                chars[chars.length-i-1]=temp;
//            }
//            return new String(chars);
//        }else{
//            return "";
//        }
//    }


}
