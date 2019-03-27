"""
1. 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
"""


def reverse(s):
    if s == "":
        return s
    return s[0] + reverse(s[1:])


if __name__ == '__main__':
    a = "abcd"
    print(reverse(a))
