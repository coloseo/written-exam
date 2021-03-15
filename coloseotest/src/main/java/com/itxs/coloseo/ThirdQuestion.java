package com.itxs.coloseo;


import java.util.Arrays;

/**
 * 用归并排序将3，1，4，1，5，9，2，6 排序
 * 归并排序 使用递归的思想，分而治理，先向左分，然后向右分，最后合起来
 * @author it小帅
 * @version 1.0
 * @datetime 2021/3/15 16:00
 */
public class ThirdQuestion {
    public static void main(String[] args) {
        int[] arr={3,1,4,1,5,9,2,6};
        int[] temp=new int[arr.length];
        mergeSort(arr,0, arr.length-1,temp);
        System.out.println("排序后的结果"+ Arrays.toString(arr));
    }

    /**
     * 归并排序的流程
     * @param arr 待排序的数组
     * @param left 数组左边索引
     * @param right 数组右边索引
     * @param temp 做中转的数组
     */
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        //使用递归的思想
        if(left<right){
            int mid=(left+right)/2;
            //向左进行递归的分解
            //向左进行分解递归
            mergeSort(arr,left,mid,temp);
            //向右进行分解递归
            mergeSort(arr,mid+1,right,temp);
            //分解之后我们进行合并；
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     * 归并排序z最后合并的过程的过程
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始下标
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 做中转的数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;//初始化索引，左边有序序列的初始下标
        int j=mid+1;//初始索引，右边有序序列的初始下标
        int t=0;//指向temp的初始索引

        //(一)
        //把左右两边有序序列按照规则填充到中转temp数组
        //知道左右两边有序序列，有一边处理完为止
        while (i<=mid&&j<=right){
            if(arr[i]<arr[j]){//说明左边有序序列某个下标对应的值小于右边有序序列，就将左边的值填充到右边序列中
                temp[t]=arr[i];
                i++;
                t++;
            }else{//说明右边有序序列下标对应的值小于左边有序序列的值
                temp[t]=arr[j];
                j++;
                t++;
            }
        }

        //(二)
        //上面过程两个序列中可能会有一个序列会有剩余
        //我们就将剩余的全部填充到temp数组中去
        while (i<=mid){
            temp[t]=arr[i];
            i++;
            t++;
        }

        while (j<=right){
            temp[t]=arr[j];
            j++;
            t++;
        }

        //注：我们合并只有最后一次合并才是把所有的数据拷贝到temp中去
        //然后我们将temp数组的数据拷贝到arr中qu
        t=0;
        int tempLeft=left;//比如我们第一次合并元素的下标是0（tempLeft）,1（right）；第二次合并是2（tempLeft）,3（right）；第三次合并下标就是0,3
        //一次类推，最后一次合并为0,7；
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }
    }
}
