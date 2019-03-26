# coding=utf-8



def expr(args):
    calc_list = list(set(args) & {"+", "-", "*", "%"})
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
    str_expr = input()
    args = str_expr.split(" ")[1:]
    expr(args)
