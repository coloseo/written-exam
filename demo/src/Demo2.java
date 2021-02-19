import java.util.Scanner;
import java.util.Stack;

/**
 * @author SamKK
 * @version 1.0
 * @date 2021/2/18 23:38
 */
public class Demo2 {
    public static Integer expr(String inner) {
        if (!inner.startsWith("expr")) {
            return null;
        }
        String[] tokens = new String[]{};
        String innerSub = inner.substring(5);
        tokens = innerSub.split(" ");
        if (tokens == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int num1, num2;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                if (tokens[i].equals("+") && stack.size() > 1) {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    num2 = num2 + num1;
                    stack.push(num2);
                } else if (tokens[i].equals("-") && stack.size() > 1) {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    num2 = num2 - num1;
                    stack.push(num2);
                } else if (tokens[i].equals("*") && stack.size() > 1) {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    num2 = num2 * num1;
                    stack.push(num2);
                } else if (tokens[i].equals("/") && stack.size() > 1) {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    num2 = num2 / num1;
                    stack.push(num2);
                } else {
                    return 0;
                }
            } else {
                //数字字符串转int型
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            //以空格为分隔符
            System.out.println(expr(scanner.next()));
        }
    }
}

