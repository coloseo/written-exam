// 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
public class reverse {
    // 递归
    public static String reversed(String str){
        int length = str.length();
        if (length <= 1) {
            return str;
        }
        String left = str.substring(0, length / 2);
        String right = str.substring(length/2, length);
        return reversed(right) + reversed(left);
    }
    public static void main(String[] args) {
        String str = "acbdfqe";
        String reversed = reversed(str);
        System.out.println(reversed);
    }
}
