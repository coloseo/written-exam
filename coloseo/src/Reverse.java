/**
 * @author 马强
 */

public class Reverse {
    public static void main(String[] args) {
        System.out.println(rev("abcdef"));
    }

    static String rev(String s) {
        if (null == s || s.length() <= 1) {
            return s;
        }
        return s.charAt(s.length()-1)+rev(s.substring(0,s.length()-1));
    }

}
