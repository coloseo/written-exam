# coding=utf-8


def cal(s):
    nums = []
    l = ['+', '-', '*', '/']
    for i in s[5:].split():
        if i not in l:
            nums.append(i)
        else:
            a, b = nums.pop(), nums.pop()
            nums.append(str(eval(b + i + a)))
    return eval(nums.pop())


if __name__ == '__main__':
    print(cal('expr 2 3 4 + *'))
