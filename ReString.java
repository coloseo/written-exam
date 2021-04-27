import org.junit.Test;

public class ReString {
    public int reStr(char[] arr2,int index2){
        if(index2 == arr2.length-1){
            System.out.print(arr2[index2]);
            return 0;
        }else{
            reStr(arr2,index2+1);
            System.out.print(arr2[index2]);
        }
        return 0;
    }
    @Test
    public void test(){
        int index1 = 0;
        System.out.println("反转之前：HelloWorld!");
        String str1 = "HelloWorld!";
        char[] arr1 = str1.toCharArray();
        System.out.print("反转之后：");
        reStr(arr1,index1);
    }
}