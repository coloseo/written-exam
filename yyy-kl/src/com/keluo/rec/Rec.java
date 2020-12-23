package com.keluo.rec;

import java.util.Arrays;

public class Rec {
	public static void main(String[] args) {
		int[] i_arr = new int[] {3, 1, 4, 1, 5, 9, 2, 6};
		System.out.println("排序前: " +Arrays.toString(i_arr));
		rec(i_arr, 0, i_arr.length - 1);
		System.out.println("排序后: " +Arrays.toString(i_arr));
	}
	
	//两路归并 
	private static void rec(int[] i_arr, int left, int right) { 
		 if (left >= right) return; 
		 int center = (left + right) / 2;  // 中间数据角标索引 
		 rec(i_arr, left, center);   // 对左边数组进行递归 
		 rec(i_arr, center + 1, right); // 对右边数组进行递归 
		 merge(i_arr, left, center, center + 1, right); // 合并 
	} 
		  
	public static void merge(int[] i_arr, int leftStart, int leftEnd, int rightStart, int rightEnd) { 
		 int i = leftStart; 
		 int j = rightStart; 
		 int k = 0; 
		 int[] temp = new int[rightEnd - leftStart + 1]; // 临时存放归并结果的数组 
		// 确认分割后的两段数组是否都取到了最后一个元素 
		 while (i <= leftEnd && j <= rightEnd) { 
			// 从两个数组中取出最小的放入临时数组 
		 	if (i_arr[i] > i_arr[j]) {  
		 		temp[k++] = i_arr[j++]; 
			} else { 
				temp[k++] = i_arr[i++]; 
			} 
		 } 
		 // 将左边或右边剩余部分的数放入临时数组
		 while (i <= leftEnd) { 
		  temp[k++] = i_arr[i++]; 
		 } 
		 while (j <= rightEnd) { 
		  temp[k++] = i_arr[j++]; 
		 } 
		 k = leftStart; 
		 // 将排序好的临时数组的数拷贝回原数组中对应索引覆盖
		 for (int element : temp) { 
			 i_arr[k++] = element; 
		 } 
	} 
} 