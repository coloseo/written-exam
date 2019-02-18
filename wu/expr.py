def expr(s):
    s = s.split()
    if s[0] != 'expr':
        return '命令错误，请使用 expr '
    else:
        s = s[1:]
    ans = []
    for i in s:
        if i in ['+', '-', '*', '/']:
            # eval()函数可以直接将字符串格式化并计算输出，不用 eval() 就用 4 个 if 判断解决。
            try:
                ans[-2] = eval(str(ans[-2]) + i + str(ans[-1]))
                ans.pop()
            except:
                return ('表达式错误，请重新输入')
        else:
            ans.append(i)
    if len(ans) == 1:
        # 去除无效0
        return ('{:g}'.format(ans[0]))
    else:
        return ('表达式错误，请重新输入')

def test():
    assert expr('expr 2 3 4 + * ') == '14', '运算错误，快改bug'
    assert expr('expr 9 3 1 - 3 * + 10 2 / + ') == '20', '运算错误，快改bug'
    assert expr('expr 9 3 1 - 3 * +  8 2 / + ') == '19', '运算错误，快改bug'
    assert expr('expr 466 25 4 * - 6 / 14 * ') == '854', '运算错误，快改bug'
    assert expr('expr 3 7 * 2 5 / + 257 325 2 * + 5 / + 627 - ') == '-424.2', '运算错误，快改bug'
    assert expr('expr 43 32 + 357 352 - / ') == '15', '运算错误，快改bug'
    assert expr('expr 56 19 * 25 8 * + ') == '1264', '运算错误，快改bug'



if __name__ == '__main__':
    test()
    while True:
        s = input('请输入命令:(输入n为退出)\n')
        if s == 'n' or s == 'N':
            break
        else:
            print(expr(s))