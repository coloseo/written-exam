"""
auth:wb
date:2019-3-26
py_version:3.6.4
2. 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令
expr 2 3 4 + *
"""
# 笔试题，不考虑参数不足以及非数字情况
import sys
args = sys.argv
s_l = []
math_sign = ("-", "+", "*", "/")
for i in args[1:]:
    if i not in math_sign:
        s_l.append(str(i))
    else:
        s_l.append(str(eval(s_l.pop(-2) + i + s_l.pop(-1))))
print(s_l[0])
