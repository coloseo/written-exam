/**
 * @author SamKK
 * @version 1.0
 * @date 2021/2/18 23:34
 */
public class Demo1 {

    public static String reverse(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverse("abcdef"));
    }
}
