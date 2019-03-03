/**
 * @Author：史泽颖
 * @Date： Create in  2019-03-03  19:37
 * @Description：用归并排序将3，1，4，1，5，9，2，6 排序。
 */
public class MergeSort {

    public static int[] mergeSort(int[] nums) {
        int[] temp = new int[nums.length];// 先建立一个临时数组,避免递归中频繁开辟空间
        sort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private static void sort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid, temp);// 左边归并排序，使得左子序列有序
            sort(nums, mid + 1, right, temp);// 右边归并排序，使得右子序列有序
            merge(nums, left, mid, right, temp);

        }

    }

    private static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;// 做序列指针
        int j = mid + 1;// 右序列指针
        int t = 0;// 临时数组指针
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }
        while (i <= mid) {// 将左边的剩余元素填充进temp中
            temp[t++] = nums[i++];
        }
        while (j <= right) {// 将右边的剩余元素填充进temp中
            temp[t++] = nums[j++];
        }
        t = 0;
        // 将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            nums[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int [] nums={3,1,4,1,5,9,2,6};
        int[] ints = mergeSort(nums);
        for (int i:ints) {
            System.out.print(i+"\t");
        }
    }





}
