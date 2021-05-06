/**
 * @author 马强
 */

import java.util.LinkedList;

public class expr {

    public static void main(String[] args) {
        //记录栈操作数
        Float a, b, c;
        LinkedList<String> str1 = new LinkedList<>();
        LinkedList<Float> str2 = new LinkedList<>();
        for (String arg : args) {
            str1.add(arg);
        }
        for (String s : str1) {

            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                a = str2.get(str2.size() - 1);
                b = str2.get(str2.size() - 2);
                if (s.equals("+")) {
                    c = a + b;
                } else if (s.equals("-")) {
                    c = a - b;
                } else if (s.equals("*")) {
                    c = a * b;
                } else {
                    c = a / b;
                }
                //pop
                if (str2.size() != 1) {
                    str2.remove(str2.get(str2.size() - 1));
                    str2.remove(str2.get(str2.size() - 1));
                }
                str2.add(c);
            } else {
                str2.add(Float.parseFloat(s));
            }
        }
        System.out.println(str2.get(0));
    }
}
