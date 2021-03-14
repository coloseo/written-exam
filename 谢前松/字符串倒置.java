package pers.xqs.algorithm;

public class 字符串倒置 {
    /**
     * 倒置字符串
     * @param s
     * @return
     */
    public static String reverse(String s) {
        if (s.length() <= 1 || s == null) {
            return s;
        } else {
            //return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
            return reverse(s.substring(1)) + s.charAt(0);
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse("abcdefg"));
    }
}
