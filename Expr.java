import org.junit.Test;

public class Expr {
    public void calculate(String[] arr2){
        int pre = Integer.parseInt(arr2[0]);
        int index = 0;
        //找到操作码的起始位置
        for(int i=0;i<arr2.length-2;i++) {
            if(arr2[i+2].equals("+")||arr2[i+2].equals("-")||arr2[i+2].equals("*")||arr2[i+2].equals("/")){
                index = i+2;
                break;
            }
        }
        //计算逆波兰式
        int length = index;
        for(int i=0;i<length-1;i++){
            switch (arr2[index]){
                case "+":
                    pre += Integer.parseInt(arr2[i+1]);
                    index++;
                    continue;
                case "-":
                    pre -= Integer.parseInt(arr2[i+1]);
                    index++;
                    continue;
                case "*":
                    pre *= Integer.parseInt(arr2[i+1]);
                    index++;
                    continue;
                case "/":
                    pre /= Integer.parseInt(arr2[i+1]);
                    index++;
            }
        }
        System.out.println("计算结果：" + pre);
    }
    @Test
    public void test(){
        System.out.println("逆波兰式：2 3 4 + *");
        String str1 = "2 3 4 + *";
        //字符串转字符串数组
        String[] arr1 = str1.split(" ");
        //计算逆波兰式
        calculate(arr1);
    }
}
