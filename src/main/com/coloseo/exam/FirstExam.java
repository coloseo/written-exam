package com.coloseo.exam;

/**
 * LeetCode原题 使用递归实现字符串反转
 */
public class FirstExam {
    /**
     * 两边往中间两两交换
     * @param s 字符数组
     */
    public static void reverseStringToCenter(char[] s) {
        if (s == null || s.length == 0)
            return;
        reverseStringHelper(s, 0, s.length - 1);
    }

    /**
     *
     * @param s 字符数组
     * @param left 左索引
     * @param right 右索引
     * 如果左边大于右边则返回斗则不断自增左边索引，自减右边索引 递归交换
     */
    public static void reverseStringHelper(char[] s, int left, int right) {
        if (left >= right)
            return;
        swap(s, left, right);
        reverseStringHelper(s, ++left, --right);
    }

    /**
     *  交换左右索引的值 提供一个中间的临时接收char数组
     * @param array
     * @param i
     * @param j
     */
    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



    public static void main(String[] args) {
        char[] chars = {'d','e','f'};
        reverseStringToCenter(chars);
        System.out.println(chars);
    }





}
