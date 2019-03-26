# ren
# 2:编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *


def expr(args):
    calc_list = list(set(args) and {"+", "-", "*", "%"})
    num_list = list(set(args) - set(calc_list))
    calc_express = ""
    for _ in range(len(calc_list)):
        num = num_list.pop(0)
        calc_express += num
        calc = calc_list.pop(0)
        calc_express += calc
    calc_express += num_list[-1]
    print(calc_express)
    print(eval(calc_express[::-1]))


if __name__ == '__main__':
    str_expr = input()  # 获取输入值
    args = str_expr.split(" ")[1:]  # 提取有效值
    expr(args)
