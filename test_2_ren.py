# ren
# 2:编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *


def expr(args):
    signs = list(set(args) and {"+", "-", "*", "%"})
    numbers = list(set(args) - set(signs))
    expression = ""
    for _ in range(len(signs)):
        num = numbers.pop(0)
        expression += num
        singn = signs.pop(0)
        expression += singn
        expression += numbers[-1]
    print(expression)
    print(eval(expression[::-1]))


if __name__ == '__main__':
    str_expr = input()
    args = str_expr.split(" ")[1:]
    expr(args)
