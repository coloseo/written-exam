# -*- coding: utf-8 -*-
# @Time    : 2021/6/26 11:30 上午
# @Author  : puliang
# @File    : wriitten_exa.py
from heapq import merge


def string_flip(s):
    """
    字符串翻转
    :param s:  字符串
    :return:
    """
    return "" if not s or len(s) == 0 else string_flip(s[1:]) + s[0]


def merge_sort(sorted_list):
    """
    归并排序
    :param sorted_list: 排序列表
    :return:
    """
    if len(sorted_list) <= 1:
        return sorted_list
    middle = int(len(sorted_list) / 2)
    left = merge_sort(sorted_list[:middle])
    right = merge_sort(sorted_list[middle:])
    return list(merge(left, right))


def deduplication(data_json):
    """
    json数据去重
    :param data_json: json数据
    :return:
    """
    new_dict = {}
    new_data = []
    for item in data_json:
        if item["serial"] not in new_dict:
            new_data.append(item)
        new_dict[item["serial"]] = item["serial"]
    return new_data


def recursion(json_data,pid):
    new_data = []
    for item in json_data:
        if item['parent'] == pid:
            next_pid = item['code']
            item['sons'] = recursion(json_data, next_pid)
            new_data.append(item)

    return new_data


class Solution:
    def __init__(self):
        self.Operator_priority = {
            "+": 0,
            "-": 0,
            "*": 1,
            "/": 1
        }
        self.Operator = ["+", "-", "*", "/"]
        self.DemarcationSymbol = ["(", ")"]
        self.L = []
        self.stack = []

    def solve(self, s):
        self.infix_to_suffix(s)
        return self.suffix_to_result(self.L)

    @staticmethod
    def change_typeof_expression(expression):
        temp_expression = []
        temp_num = ""
        for exp in expression:
            if exp.isdigit():
                temp_num += exp
                continue
            else:
                temp_expression.append(temp_num)
                temp_num = ""
                temp_expression.append(exp)
        temp_expression.append(temp_num)
        return temp_expression

    def infix_to_suffix(self, expression):
        temp_expression = self.change_typeof_expression(expression)
        for item in temp_expression:
            if item.isdigit():
                self.L.append(item)
            elif item in self.Operator:  # 判断是否是操作符
                while len(self.stack) != 0 and self.stack[-1] in self.Operator and self.Operator_priority[item] <= \
                        self.Operator_priority[self.stack[-1]]:
                    self.L.append(self.stack.pop())
                self.stack.append(item)

            elif item in self.DemarcationSymbol:  # 判断是否是分隔符
                if item == "(":
                    self.stack.append(item)
                elif item == ")":
                    while len(self.stack) != 0 and self.stack[-1] != "(":
                        self.L.append(self.stack.pop())
                    if len(self.stack) != 0:
                        self.stack.pop()

        while len(self.stack) != 0:
            self.L.append(self.stack.pop())

    def suffix_to_result(self, suffix_expression):
        for item in suffix_expression:
            if item.isdigit():  # 如果是数字就添加到stack中去
                self.stack.append(item)
            elif item in self.Operator:
                num1 = self.stack.pop()
                num2 = self.stack.pop()
                temp_value = self.calculation(float(num2), float(num1), item)
                self.stack.append(temp_value)
        return self.stack.pop()

    @staticmethod
    def calculation(num1, num2, op):
        if op == "+":
            return num1 + num2
        elif op == "-":
            return num1 - num2
        elif op == "*":
            return num1 * num2
        else:
            return num1 / num2


if __name__ == '__main__':
    # 字符串翻转
    print(string_flip('天安门广场上有一群人在等着升国旗'))
    # 归并排序
    data = [3, 1, 4, 1, 5, 9, 2, 6]
    print(merge_sort(data))
    # json数据去重
    parm = [{
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
    print(deduplication(parm))
    # json数据生成递归树
    data_list = [
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
    print(recursion(data_list, ''))
    # 逆波兰表达式
    s = Solution()
    print(s.solve("2 3 4+*"))
