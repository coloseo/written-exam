# -*- coding: utf-8 -*-
# Author : hejianxin
# Time : 2021/2/20 3:19 下午
import re


# 1题 反转
data = 'abcdefg'
def reverse(input_data: str, res_data='', index=0) -> str:
    if index != len(data):
        res_data += input_data[-1]
        index += 1
        return reverse(input_data[:-1], res_data, index)
    return res_data

# print(reverse(data))


# 2题 不大明白
def expr(expression: list):
    expr_list = []
    for num in expression:
        if num not in ['+', '-', '*', '/']:
            # 判断是数字还是符号,
            expr_list.append(float(num))
        else:
            first_num = expr_list[-1]
            end_num = expr_list[-2]
            # 删除取走的两位数
            del expr_list[-1]
            del expr_list[-1]
            if num == '+':
                expr_list.append(first_num + end_num)
            elif num == '-':
                # 前面减后面
                expr_list.append(end_num - first_num)
            elif num == '*':
                expr_list.append(first_num * end_num)
            elif num == '/':
                expr_list.append(end_num / first_num)
    # 最后应该返回一个值，多个值代表输入有问题
    assert len(expr_list) == 1, f'invalid parameter {expression}'
    return expr_list[0]

print(expr(['1', '2','+', '3', '4', '+', '*']))
print(expr(['2', '1', '3', '4', '+', '*', '-']))

# 3题 不大了解归并排序，会冒泡排序
test_sort_list = [3,1, 4, 1, 5, 9, 2, 6]
def my_sort(sort_list: list) -> list:
    for out_index in range(len(sort_list)):
        for in_index in range(len(sort_list) - 1 - out_index):
            if sort_list[in_index] > sort_list[in_index+1]:
                sort_list[in_index], sort_list[in_index+1] = sort_list[in_index+1], sort_list[in_index]
    return sort_list

# print(my_sort(test_sort_list))


# 4题
test_distinct_dict = [{
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

def distinct_json(distinct_list: list):
    res_dict = {}
    for data_dict in distinct_list:
        res_dict.setdefault(data_dict['serial'], data_dict)
    return [i for i in res_dict.values()]

# print(distinct_json(test_distinct_dict))


# 5题
test_tree_list = [
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

def tree(data_list):
    data = {}
    china = None
    for province in data_list: # 遍历省份
        sub_province_list = []
        for sub_province in data_list:
            if sub_province['parent'] == province['code']:
                sub_province_list.append(sub_province)
        if sub_province_list:
            data[str(province['code'])] = sub_province_list
        if not province['parent']:
            china = province

    res_data = china
    res_data['children'] = []
    # def find_data(res_data):
    #     # 找出当前节点对子节点
    #     # print(res_data)
    #     children_list = data.get(res_data['code'])
    #     if not children_list:
    #         # 找不到子节点
    #         pass
    #     else:
    #         res_data['children'] = children_list
    #         for children in children_list:
    #             # 找到当前子省份
    #             sub_children = data.get(children['code'])
    #             if sub_children:
    #                 print(children)
    #                 children['children'] = sub_children
    #                 return find_data(res_data)
    #             # res_data['children'] = children
    #             # if sub_children:
    #             #     print(sub_children, 1111)
    #                 # return find_data(res_data)
    #     return res_data
    # find_data(res_data)
    def find_data(find_node_list, res_data={}):
        # 找出当前节点对子节点
        for find_node in find_node_list:
            children_list = data.get(find_node['code'])
            if children_list:
                find_node['children'] = children_list
                if res_data == {}:
                    res_data.update(find_node)
                for children in children_list:
                    find_data([children], res_data)
        return res_data
    return find_data([res_data])

    # print(find_data(res_data))

        # if province['parent'] == '': # 判断是不是中国
        #     res_data = province
        # for sub_province in data: # 找出当前省份对子省份
        #     if sub_province['parent'] == province['code']:
        #         if res_data:
        #             exist_china = res_data.get('children')
        #             if not exist_china:
        #                 res_data['children'] = [sub_province]
        #             else:
        #                 res_data['children'].append(sub_province)

        # if not province['parent']:
        #     找出中国
            # res_data = province
            # parent_code = province['code']
        # if province['parent'] and province['parent'] == parent_code:
        #     province['children'] = province
        #     res_data['children'] = 1
# print(tree(test_tree_list))


