/**
 * @auth chenxuean
 * @date 2021/4/20
 * @time 13:32
 */
public class three {

    public static void main(String[] args) {
        int[] arr = {3,1,4,1,5,9,2,6};
        int[] tmp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,tmp);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void merge(int[] arr,int low,int mid,int high,int[] tmp){
        int i = 0;
        int j = low,k = mid+1;
        while(j <= mid && k <= high){
            if(arr[j] < arr[k]){
                tmp[i++] = arr[j++];
            }else{
                tmp[i++] = arr[k++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp中
        while(j <= mid){
            tmp[i++] = arr[j++];
        }

        while(k <= high){
            tmp[i++] = arr[k++];
        }

        for(int t=0;t<i;t++){
            arr[low+t] = tmp[t];
        }
    }

    public static void mergeSort(int[] arr,int low,int high,int[] tmp){
        if(low<high){
            int mid = (low+high)/2;
            //对左边序列进行归并排序
            mergeSort(arr,low,mid,tmp);
            //对右边序列进行归并排序
            mergeSort(arr,mid+1,high,tmp);
            //合并两个有序序列
            merge(arr,low,mid,high,tmp);
        }
    }
}
