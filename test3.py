"""
3. 用归并排序将3，1，4，1，5，9，2，6 排序。
"""


def merge_sort(data):
    if len(data) <= 1:
        return data
    middle = int(len(data) / 2)
    left = merge_sort(data[:middle])
    right = merge_sort(data[middle:])
    temp_list = []
    while left and right:
        temp_list.append(left.pop(0) if left[0] <= right[0] else right.pop(0))
    temp_list += left or right
    return temp_list


if __name__ == '__main__':
    data_list = [3, 1, 4, 1, 5, 9, 2, 6]
    print(merge_sort(data_list))
