package pers.xqs.algorithm;

public class 归并排序 {

    public static void main(String[] args) {
        int[] A = {3, 1, 4, 1, 5, 9, 2, 6};
        for (int i : A) System.out.print(i+" ");
        System.out.println();
        MergeSort(A);
        for (int i : A) System.out.print(i+" ");
        System.out.println();
    }

    public static void MergeSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(array, low, mid);
            sort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    public static void merge(int[] array, int low, int mid, int high) {
        // 声明新的数组,临时储存归并结果
        int[] B = new int[high - low + 1];
        int h = low;
        int i = 0;
        int j = mid + 1;
        while (h <= mid && j <= high) {
            if (array[h] <= array[j]) {
                B[i] = array[h];
                h++;
            } else {
                B[i] = array[j];
                j++;
            }
            i++;
        }
        // 等号很重要
        if (h <= mid) {
            for (int k = h; k <= mid; k++) {
                B[i] = array[k];
                i++;
            }
        } else {
            for (int k = j; k <= high; k++) {
                B[i] = array[k];
                i++;
            }
        }
        for (int k = low; k < high; k++) {
            array[k] = B[k - low];
        }
    }
}
