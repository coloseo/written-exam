package com.test1;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @description:
 * @author: 付益民
 * @create: 2021-02-22-13:15
 */
public class Work1 {
    public static void main(String[] args) {
        //1.
        String ss = "abcd";
        System.out.println(reverse(ss));

        //3.
        int[] nums = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] ints = mergeSort(nums, 0, nums.length - 1);
        for (int num : ints) {
            System.out.print(num);
        }

        //4.
        String str = "[{\n" +
                "    \"name\": \"张三\",\n" +
                "    \"serial\": \"0001\"\n" +
                "  }, {\n" +
                "    \"name\": \"李四\",\n" +
                "    \"serial\": \"0002\"\n" +
                "  }, {\n" +
                "    \"name\": \"王五\",\n" +
                "    \"serial\": \"0003\"\n" +
                "  }, {\n" +
                "    \"name\": \"王五2\",\n" +
                "    \"serial\": \"0003\"\n" +
                "  }, {\n" +
                "    \"name\": \"赵四\",\n" +
                "    \"serial\": \"0004\"\n" +
                "  }, {\n" +
                "    \"name\": \"小明\",\n" +
                "    \"serial\": \"005\"\n" +
                "  }, {\n" +
                "    \"name\": \"小张\",\n" +
                "    \"serial\": \"006\"\n" +
                "  }, {\n" +
                "    \"name\": \"小李\",\n" +
                "    \"serial\": \"006\"\n" +
                "  }, {\n" +
                "    \"name\": \"小李2\",\n" +
                "    \"serial\": \"006\"\n" +
                "  }, {\n" +
                "    \"name\": \"赵四2\",\n" +
                "    \"serial\": \"0004\"\n" +
                "  }]";

        String deduplication = Deduplication(str);
        System.out.println("deduplication = " + deduplication);

    }

    /**
     * 1.编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
     */
    public static String reverse(String str) {
        int index = str.length();
        if (index == 1) {
            return str;
        } else {
            char c = str.charAt(index - 1);//取字符串最后一个字符
            index--;
            String result = c + reverse(str.substring(0, index));//递归
            return result;
        }
    }

    /**
     * 2.编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。
     * 例如，命令 expr 2 3 4 + *
     */

    /**
     * 3.用归并排序将3，1，4，1，5，9，2，6 排序。
     */
    public static int[] mergeSort(int[] arr,int l,int r) {
        //0 4
        if (l<r) {
            int q = (l+r)/2;
            mergeSort(arr,l,q);
            mergeSort(arr,q+1,r);
            merge(arr,l,q,r);
            return arr;
        }
        return null;
    }

    /**
     *
     * @param arr  排序数组
     * @param l    数组最左边下标
     * @param q    数组中间位置下标
     * @param r    数组最右位置下标
     */
    public static void merge(int[] arr, int l, int q, int r) {
        /**因为每次切割后左边下标都是（l,q），右边数组的下标是(q+1,r)
         * 所以左边数组的元素个数就是q - l + 1
         * 右边的数组元素个数就是r - q
         * **/
        final int n1 = q-l+1;//切割后左边数组的数据长度
        final int n2 = r-q;//切割后右边数组的数据长度
        /**创建两个新数组将切割后的数组分别放进去，长度加1是为了放置无穷大的数据标志位**/
        final int[] left = new int[n1+1];//加一操作是增加无穷大标志位
        final int[] right = new int[n2+1];//加一操作是增加无穷大标志位
        //两个循环将数据添加至新数组中
        /**左边的数组下标是从l到q**/
        /**遍历左边的数组*/
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l+i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[q+1+i];
        }

        //将最大的正整数放在两个新数组的最后一位
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;

        int i = 0,j = 0;
        //谁小谁放在前面
        for (int k = l; k <= r; k++) {
            if (left[i]<=right[j]) {
                arr[k] = left[i];
                i = i+1;
            } else {
                arr[k] = right[j];
                j = j+1;
            }
        }
    }


    /**
     * 4.对下面的 json 字符串 serial 相同的进行去重。
     */
    public static String Deduplication(String str){
        String[] arrs = str.split("},");
        ArrayList<String> list = new ArrayList<>();
        /*转化arrays为list*/
        for (int i = 0; i < arrs.length; i++) {
            if (i == 0) {
                String str1 = arrs[i].substring(1);
                list.add(str1+"}");
            }
            if (i > 0 && i < arrs.length - 1) {
                String str1 = arrs[i].substring(1);
                list.add(str1+"}");
            }
            if (i == arrs.length - 1) {
                String str1 = arrs[i].substring(2, arrs[i].length() - 2);
                list.add(str1+"}");
            }
        }

        ArrayList<String> list1 = new ArrayList<>();//为serial属性创造容器
        Iterator<String> iterator = list.iterator();//迭代list
        while (iterator.hasNext()){
            String next = iterator.next();
            String num = next.split(",")[1].split(":")[1];//得到serial属性
            /*去重*/
            if (list1.contains(num)){
                iterator.remove();
            }
            list1.add(num);
        }
        String result = list.toString();
        return result;
    }

    /**
     * 5.把下面给出的扁平化json数据用递归的方式改写成组织树的形式
     */

}
