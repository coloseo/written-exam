import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


// 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *
public class ArithmeticExpr {
    public static double evaluator(double pre, double next, String operator) throws Exception {
        switch (operator) {
            case "+": return pre + next;
            case "-": return pre - next;
            case "*": return pre * next;
            case "/": return pre / next;
            default: break;
        }
        throw new Exception("illegal operator!");
    }
    public static double calculate(ArrayList<String> suffixExp) throws Exception {
        double res = 0.0;
        Stack<Double> numbers = new Stack<>();
        for (String s : suffixExp) {
            if (s.matches("[+\\-*/]")) {
                double next = numbers.pop();
                double pre = numbers.pop();
                res = evaluator(pre, next, s);
                numbers.push(res);
            } else {
                numbers.push(Double.parseDouble(s));
            }
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入表达式：");
            String line = scanner.nextLine();
            String[] array = line.replace("expr ","").split(" ");
            ArrayList<String> list = new ArrayList<>(Arrays.asList(array));

            double result = calculate(list);
            System.out.println(result);
        }

    }
}
