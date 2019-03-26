# -*- coding: utf-8 -*-
# ren


# 1编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
def reverse(s):
    if s == '':
        return s
    else:
        return reverse(s[1:]) + s[0]


print(reverse("sdaffwqgdsaewqe"))