# -*- coding: utf-8 -*-
# ren
from heapq import merge


# 1编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
def reverse(s):
    if s == '':
        return s
    else:
        return reverse(s[1:]) + s[0]


# 2 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *

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


# 3 用归并排序将3，1，4，1，5，9，2，6 排序。
def sort_list(lis):
    if len(lis) <= 1:
        return lis
    mid = int(len(lis) / 2)
    min = sort_list(lis[:mid])
    max = sort_list(lis[mid:])
    return list(merge(min, max))


# 4 对下面的 json 字符串 serial 相同的进行去重。
def foo():
    json_list1 = [{
        "name": "张三",
        "serial": "0001"
    }, {
        "name": "李四",
        "serial": "0002"
    }, {
        "name": "王五",
        "serial": "0003"
    }, {
        "name": "王五2",
        "serial": "0003"
    }, {
        "name": "赵四",
        "serial": "0004"
    }, {
        "name": "小明",
        "serial": "005"
    }, {
        "name": "小张",
        "serial": "006"
    }, {
        "name": "小李",
        "serial": "006"
    }, {
        "name": "小李2",
        "serial": "006"
    }, {
        "name": "赵四2",
        "serial": "0004"
    }]

    values = {_.get("serial") for _ in json_list1}
    new_list = []
    for v in json_list1:
        if v.get("serial") in values:
            values.remove(v.get("serial"))
            new_list.append(v)
    return new_list


# 5 把下面给出的扁平化json数据用递归的方式改写成组织树的形式
def get_vlues(dic):

    parents = {k.get("code"): k.get("parent") for k in json_list2}
    if dic.get("code") not in parents.values():
        return dic
    else:
        dic["child"] = []
        for v in json_list2:
            if v.get("parent") == dic.get("code"):
                dic["child"].append(get_vlues(v))
    return dic


json_list2 = [
        {
            "id": "1",
            "name": "中国",
            "code": "110",
            "parent": ""
        },
        {
            "id": "2",
            "name": "北京市",
            "code": "110000",
            "parent": "110"
        },
        {
            "id": "3",
            "name": "河北省",
            "code": "130000",
            "parent": "110"
        },
        {
            "id": "4",
            "name": "四川省",
            "code": "510000",
            "parent": "110"
        },
        {
            "id": "5",
            "name": "石家庄市",
            "code": "130001",
            "parent": "130000"
        },
        {
            "id": "6",
            "name": "唐山市",
            "code": "130002",
            "parent": "130000"
        },
        {
            "id": "7",
            "name": "邢台市",
            "code": "130003",
            "parent": "130000"
        },
        {
            "id": "8",
            "name": "成都市",
            "code": "510001",
            "parent": "510000"
        },
        {
            "id": "9",
            "name": "简阳市",
            "code": "510002",
            "parent": "510000"
        },
        {
            "id": "10",
            "name": "武侯区",
            "code": "51000101",
            "parent": "510001"
        },
        {
            "id": "11",
            "name": "金牛区",
            "code": "51000102",
            "parent": "510001"
        }
    ]


if __name__ == '__main__':
    # 1 第一题答案
    print(reverse("sdaffwqgdsaewqe"))
    # 2 第二题答案
    s = input("请输入逆波兰表达式(例如expr 2 3 4 + *): ")
    print(cal(s))
    # 3 第三题答案
    print(sort_list([3, 1, 4, 1, 5, 9, 2, 6]))
    # 4 第四题答案
    print(foo())
    # 5 第五题答案
    print(get_vlues(json_list2[0]))
