public class Test01 {
    //编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
    public static void main(String[] args) {
        String s = "abcdefg";
        String s2 = reverse(s);
        System.out.println(s2);
    }

    public static String reverse(String s) {
        if (s.isEmpty()) return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }
}
