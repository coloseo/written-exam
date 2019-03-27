"""
2. 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令
expr 2 3 4 + *
"""

import sys

args = sys.argv
data_list = []
math_sign = ("+", "-", "*", "/")
for i in args[1:]:
    if i not in math_sign:
        data_list.append(str(i))
    else:
        data_list.append(str(eval(data_list.pop(-2) + i + data_list.pop(-1))))
print(data_list[0])
