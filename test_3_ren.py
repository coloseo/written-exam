# -*- coding: utf-8 -*-
# ren
# 3:用归并排序将3，1，4，1，5，9，2，6 排序。
from heapq import merge


def sort_list(lis):
    if len(lis) <= 1:
        return lis
    mid = int(len(lis) / 2)
    min = sort_list(lis[:mid])
    max = sort_list(lis[mid:])
    return list(merge(min, max))


print(sort_list([3, 1, 4, 1, 5, 9, 2, 6]))
