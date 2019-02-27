
#include<stdio.h>

#define Max_ 8
// 打印结果
void Show(int  arr[], int n)
{
    int i;
    for ( i=0; i<n; i++ )
        printf("%d  ", arr[i]);
    printf("\n");
}

// 归并排序中的合并算法
void Merge(int array[], int left, int m, int right)
{
    int aux[Max_] = {0};  // 临时数组 （若不使用临时数组，将两个有序数组合并为一个有序数组比较麻烦）
    int i; //第一个数组索引
    int j; //第二个数组索引
    int k; //临时数组索引

    for (i = left, j = m+1, k = 0; k <= right-left; k++) // 分别将 i, j, k 指向各自数组的首部。
    {
        //若 i 到达第一个数组的尾部，将第二个数组余下元素复制到 临时数组中
        if (i == m+1)
        {
            aux[k] = array[j++];
            continue;
        }
        //若 j 到达第二个数组的尾部，将第一个数组余下元素复制到 临时数组中
        if (j == right+1)
        {
            aux[k] = array[i++];
            continue;
        }
        //如果第一个数组的当前元素 比 第二个数组的当前元素小，将 第一个数组的当前元素复制到 临时数组中
        if (array[i] < array[j])
        {
            aux[k] = array[i++];
        }
        //如果第二个数组的当前元素 比 第一个数组的当前元素小，将 第二个数组的当前元素复制到 临时数组中
        else
        {
            aux[k] = array[j++];
        }
    }

    //将有序的临时数组 元素 刷回 被排序的数组 array 中，
    //i = left , 被排序的数组array 的起始位置
    //j = 0， 临时数组的起始位置
    for (i = left, j = 0; i <= right; i++, j++)
    {
        array[i] = aux[j];
    }
}

// 归并排序
void MergeSort(int array[], int start, int end)
{
    if (start < end)
    {
        int i;
        i = (end + start) / 2;
        // 对前半部分进行排序
        MergeSort(array, start, i);
        // 对后半部分进行排序
        MergeSort(array, i + 1, end);
        // 合并前后两部分
        Merge(array, start, i, end);
    }
}

int main()
{   //测试数据
    int arr_test[Max_] = { 3,1,4,1,5,9,2,6 };
    //排序前数组序列
    Show( arr_test, Max_ );
    MergeSort( arr_test, 0, Max_-1 );
    //排序后数组序列
    Show( arr_test, Max_ );
    return 0;
}
