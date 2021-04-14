package com.exam;

import java.util.Arrays;

public class test03 {

    public static void main(String[] args) {

        int[] a = {3,1,4,1,5,9,2,6};
        System.out.println("排序前："+Arrays.toString(a));
        mergeSort(a);
        System.out.println("排序后："+Arrays.toString(a));

    }

    public static int[] mergeSort(int[] a) {

        int[] temp = new int[a.length];
        mergeSort(a, 0, a.length-1, temp);
        return a;

    }

    // 归并排序
    private static void mergeSort(int[] a, int left, int right, int[] temp){

        if(left < right) {
            int mid = (left+right) / 2;
            mergeSort(a, left, mid, temp);
            mergeSort(a, mid+1, right, temp);
            merge(a, left, mid, right, temp);
        }
    }

    private static void merge(int[] a, int left, int mid, int right, int[] temp){

        int i = left;
        int j = mid+1;
        int t = 0;
        while (i <= mid && j <= right) {
            if(a[i] <= a[j]) {
                temp[t++] = a[i++];
            } else {
                temp[t++] = a[j++];
            }
        }
        while(i <= mid) {
            // 将左边剩余元素填充进temp中
            temp[t++] = a[i++];
        }
        while(j <= right) {
            // 将右序列剩余元素填充进temp中
            temp[t++] = a[j++];
        }
        t = 0;
        // 将temp中的元素全部拷贝到原数组中
        while(left <= right) {
            a[left++] = temp[t++];
        }
    }

}
