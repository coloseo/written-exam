public class topic_three {
        public static void main(String[] args) {
        int[] array = {3,1,4,1,5,9,2,6};
        int i = 0;
        int j = array.length-1;
        int[] ints = merge(array,i, j);
        for (int anInt : ints) {
            System.out.print(anInt);
        }

        }
        public static int[] merge(int[] array, int i, int j){
            if (i == j){
                //如果 i == j，说明数组已经分割到只有一个元素了，直接返回给上一层即可
                return new int[]{ array[i] };
            }
            //每次分割(i + j - 1) / 2，这里减1是为了下面递归的时候，i 和 j能够有相等的机会
            int mid = (i + j - 1) / 2 ;
            //分割出的左侧的有序数组
            int[] leftArray = merge(array, i, mid);
            //分割出的右侧的有序数组
            int[] rightArray = merge(array, mid + 1, j);
            //左侧和右侧合并的新数组
            int[] newArray = new int[leftArray.length+rightArray.length];

            //左侧数组的下标
            int leftFlag = 0;
            //右侧数组的下标
            int rightFlag = 0;
            //新数组的下标
            int newFlag = 0;

            while (leftFlag<leftArray.length && rightFlag<rightArray.length){
                if (leftArray[leftFlag] <= rightArray[rightFlag]){
                    newArray[newFlag] = leftArray[leftFlag];
                    newFlag++;
                    leftFlag++;
                } else {
                    newArray[newFlag] = rightArray[rightFlag];
                    newFlag++;
                    rightFlag++;
                }
            }
            while (leftFlag<leftArray.length){
                newArray[newFlag] = leftArray[leftFlag];
                newFlag++;
                leftFlag++;
            }
            while (rightFlag<rightArray.length){
                newArray[newFlag] = rightArray[rightFlag];
                newFlag++;
                rightFlag++;
            }
            return newArray;
        }

}
