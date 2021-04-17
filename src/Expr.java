import com.sun.deploy.util.StringUtils;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expr {
    public static void main(String[] args) {
        System.out.println("请输入：");
        System.out.println("退出输入请输入【exit】结束");
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        while (scanner.hasNext()){
            String next = scanner.next();
            if(!"exit".equals(next)){
                //判断是不是数字
                if(isInteger(next+"")){
                    stack.add(next+"");
                }else {
                    String  a = stack.pop();
                    String b = stack.pop();
                    int res = stringMatching(a,b,next+"");
                    stack.add(res+"");

                }
            }else {
                break;
            }

        }
        System.out.println(stack.pop());

    }

    public  static  int stringMatching(String  a,String b, String c) {
        switch (c){
            case  "+":
                return Integer.parseInt(a) + Integer.parseInt(b);
            case  "-":
                return Integer.parseInt(a) - Integer.parseInt(b);
            case  "*":
                return Integer.parseInt(a) * Integer.parseInt(b);
            case  "/":
                return Integer.parseInt(a) / Integer.parseInt(b);
            default:
                throw new RuntimeException("没有该类型的运算符！");
        }

    }
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("\\d+");
        return pattern.matcher(str).matches();
    }



}
