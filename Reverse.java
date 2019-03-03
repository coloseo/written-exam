/**
 * @Author：史泽颖
 * @Date： Create in  2019-03-03  21:18
 * @Description：编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置
 */
public class Reverse {
    private static void reverse(char[] s, int longest) {
        char c;
        if (longest > 1) {
            /**
             * 依次交换数组中相邻的数组元素
             */
            for (int i = 0; i < longest - 1; i++) {
                c = s[i];
                s[i] = s[i + 1];
                s[i + 1] = c;
            }
            longest--;
            reverse(s, longest);
        }
    }

    public static void main(String[] args) {
        String c = "hello";
        char[] s = c.toCharArray();
        int longest=s.length;
        reverse(s,longest);
        System.out.println(s);
    }
}
