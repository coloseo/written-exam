# ren
# 3:用归并排序将3，1，4，1，5，9，2，6 排序。
from heapq import merge


def sort_list(my_list):
    if len(my_list) <= 1:
        return my_list
    middle_int = int(len(my_list) / 2)
    left = sort_list(my_list[:middle_int])
    right = sort_list(my_list[middle_int:])
    return list(merge(left, right))


if __name__ == '__main__':
    print(sort_list([3, 1, 4, 1, 5, 9, 2, 6]))
