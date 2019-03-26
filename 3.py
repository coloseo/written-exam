"""
auth:wb
date:2019-3-26
py_version:3.6.4
3. 用归并排序将3，1，4，1，5，9，2，6 排序。
"""


def merge_sort(s: list):
    if len(s) <= 1:
        return s
    middle = int(len(s) / 2)
    left = merge_sort(s[:middle])
    right = merge_sort(s[middle:])
    r = []
    while left and right:
        r.append(left.pop(0) if left[0] <= right[0] else right.pop(0))
    r += left or right
    return r


if __name__ == '__main__':
    s = [3, 1, 4, 1, 5, 9, 2, 6]
    print(merge_sort(s))
