import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author：史泽颖
 * @Date： Create in  2019-03-03  21:38
 * @Description：<描述>
 */

/**
 * 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *
 */
public class Bohr {
    public String[] operators = {"+", "-", "*", "/", "(", ")"};

    private String expression;//原始字符串
    private List<ExpressionItem> midfixExprItems = new ArrayList<ExpressionItem>();//中缀表达式
    private List<ExpressionItem> posfixExprItems = new ArrayList<ExpressionItem>();//后缀表达式（逆波兰表达式）
    private Stack<ExpressionItem> myStack = new Stack<ExpressionItem>();

    public Bohr() {
    }

    public Bohr(String expression) {
        this.expression = expression;
        preHanler();
        String[] temp = this.expression.trim().split("\\s+");
        ExpressionItem item = null;
        for (String t : temp) {
            item = new ExpressionItem(t, isOperator(t));
            midfixExprItems.add(item);
        }
    }

    //预处理给操作符两边加空格
    private void preHanler() {
        for (String str :
                operators) {
            this.expression = this.expression.replace(str, " " + str + " ");
        }

    }

    public String getMidFixExpression() {
        StringBuilder sb = new StringBuilder();
        for (ExpressionItem item1 :
                midfixExprItems) {
            sb.append(item1.getValue()).append(" ");
        }
        return sb.toString();
    }

    public String getPosFixExpression() {
        StringBuilder sb = new StringBuilder();
        for (ExpressionItem item1 :
                posfixExprItems) {
            sb.append(item1.getValue()).append(" ");
        }
        return sb.toString();
    }

    class ExpressionItem {
        private String value;
        private boolean isOperator;//是否操作符

        ExpressionItem(String value, boolean isOperator) {
            this.value = value;
            this.isOperator = isOperator;
        }

        private String getValue() {
            return value;
        }

        private void setValue(java.lang.String value) {
            this.value = value;
        }

        private boolean isOperator() {
            return isOperator;
        }

        private void setOperator(boolean operator) {
            isOperator = operator;
        }
    }

    public double parse() {
        populatePosfixExpr();
        return calculate();
    }


    /**
     * 将中缀表达式解析成后缀表达式
     *
     * @return
     */
    public String populatePosfixExpr() {
        int i, j = 0;
        ExpressionItem ch, ch1;
        myStack.clear();
        for (i = 0; i < midfixExprItems.size(); i++) {
            ch = midfixExprItems.get(i);
            if (!ch.isOperator) //如果是操作数，直接放入B中
            {
                posfixExprItems.add(ch);
            } else {
                if (ch.getValue().equals("(")) //如果是'('，将它放入堆栈中
                    myStack.push(ch);
                else if (ch.getValue().equals(")")) //如果是')'
                {
                    while (!myStack.isEmpty()) //不停地弹出堆栈中的内容，直到遇到'('
                    {
                        ch = myStack.pop();
                        if (ch.getValue().equals("("))
                            break;
                        else
                            posfixExprItems.add(ch);//将堆栈中弹出的内容放入B中
                    }
                } else //既不是'('，也不是')'，是其它操作符，比如 +, -,*,/之类的
                {
                    if (!myStack.isEmpty()) {
                        do {
                            ch1 = myStack.pop();//弹出栈顶元素
                            if (getOperPriority(ch.getValue()) > getOperPriority(ch1.getValue())) //如果栈顶元素的优先级小于读取到的操作符
                            {
                                myStack.push(ch1);//将栈顶元素放回堆栈
                                myStack.push(ch);//将读取到的操作符放回堆栈
                                break;
                            } else//如果栈顶元素的优先级比较高或者两者相等时
                            {
                                posfixExprItems.add(ch1); //将栈顶元素弹出，放入B中
                                if (myStack.isEmpty()) {
                                    myStack.push(ch); //将读取到的操作符压入堆栈中
                                    break;
                                }
                            }
                        } while (!myStack.isEmpty());
                    } else //如果堆栈为空，就把操作符放入堆栈中
                    {
                        myStack.push(ch);
                    }
                }
            }
        }
        while (!myStack.isEmpty())
            posfixExprItems.add(myStack.pop());//将堆栈中剩下的操作符输出到B中

        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        for (ExpressionItem it :
                posfixExprItems) {
            sb.append(it.getValue()).append(" ");
        }
        return sb.toString();
    }

    /**
     * 计算后缀表达式的值
     *
     * @return
     */
    private double calculate() {
        int i;
        double no1, no2, ret;
        ExpressionItem ch, ch1, ch2;

        ExpressionItem item = null;
        myStack.clear();

        for (i = 0; i < posfixExprItems.size(); i++) {
            ch = posfixExprItems.get(i);
            if (!ch.isOperator())//如果是操作数，直接 压入栈
            {
                myStack.push(ch);
            } else //如果是操作符，就弹出两个数字来进行运算
            {
                ch1 = myStack.pop();
                ch2 = myStack.pop();

                ret = doCalculate(ch.getValue(), Double.parseDouble(ch1.getValue()), Double.parseDouble(ch2.getValue()));
                item = new ExpressionItem(ret + "", false);
                myStack.push(item);//将结果压入栈
            }
        }

        return Double.parseDouble(myStack.pop().getValue());//弹出最后的运算结果
    }

    /**
     * 对两个值利用运算符计算结果
     *
     * @param op
     * @param ch1
     * @param ch2
     * @return
     */
    private double doCalculate(String op, double ch1, double ch2) {
        switch (op) {
            case "+":
                return ch2 + ch1;
            case "-":
                return ch2 - ch1;
            case "*":
                return ch2 * ch1;
            case "/":
                return ch2 / ch1;
            default:
                return 0;
        }
    }

    //判断是否是操作符
    private boolean isOperator(String ch) {
        for (int i = 0; i < operators.length; i++)
            if (operators[i].equals(ch))
                return true;
        return false;
    }

    //返回运算符的优先级
    private int getOperPriority(String ch) {
        int priority;

        switch (ch) {
            case "+":
                priority = 1;
                break;
            case "-":
                priority = 1;
                break;
            case "*":
                priority = 2;
                break;
            case "/":
                priority = 2;
                break;
            default:
                priority = 0;
                break;
        }

        return priority;
    }

    public static void main(String[] args) {
        String s = "(500/5)- 2) *2 - 1";
        Bohr psp = new Bohr(s);
        System.out.println("The result is: " + psp.parse());
    }
}
