package com.tengxq.sort;

/**
 * 归并排序
 *
 * @author: tengxq
 * @since: 2021-03-11 16:32
 */

import java.util.Arrays;


public class MergeSortDemo {
    public static void main(String[] args) {
        int[] arrays = new int[] {3,1,4,1,5,9,2,6};
        mergesort(arrays);
        System.out.println(Arrays.toString(arrays));

    }

    public static void mergesort(int[] arr) {
        //开辟一个临时数组，避免后面频繁申请新的空间
        int[] tempArr = new int[arr.length];
        sort(arr, 0, arr.length - 1, tempArr);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int p = left;
        int q = mid + 1;
        int t = 0;
        while (p <= mid && q <= right) {
            //小的数放前面
            if (arr[p] <= arr[q]) {
                temp[t++] = arr[p++];
            } else {
                temp[t++] = arr[q++];
            }
        }
        //剩下的数直接顺序放入
        while (p <= mid) {
            temp[t++] = arr[p++];
        }
        while (q <= right) {
            temp[t++] = arr[q++];
        }
        //将临时数组中拍好序的结果，放入真数组中
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

}
