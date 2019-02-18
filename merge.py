def merge(l):
    if len(l) == 1:
        return l
    mid = len(l) // 2
    left = l[:mid]
    right = l[mid:]
    l_ans = merge(left)
    r_ans = merge(right)
    return merge_buffer(l_ans, r_ans)


def merge_buffer(left, right):
    ans = []
    while len(left) > 0 and len(right) > 0:
        if left[0] >= right[0]:
            ans.append(right.pop(0))
        else:
            ans.append(left.pop(0))
    while len(left) > 0:
        ans.append(left.pop(0))
    while len(right) > 0:
        ans.append(right.pop(0))
    return ans


def test():
    assert merge([4, 6, 1, 3, 0, 5, 2, 1, 8, 7, 10]) == [0, 1, 1, 2, 3, 4, 5, 6, 7, 8, 10], '排序错误'
    assert merge([5, 7, 8, 9, 10, 1, 3, 7, 15, 18]) == [1, 3, 5, 7, 7, 8, 9, 10, 15, 18], '排序错误'
    assert merge([-1, -3, 7, 1, 8, 10, 89, -52, 37]) == [-52, -3, -1, 1, 7, 8, 10, 37, 89], '排序错误'


if __name__ == '__main__':
    test()
    print(merge([3, 1, 4, 1, 5, 9, 2, 6]))
