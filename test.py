# author: 王一臣

# 第一题

def reverse(num):
    if num == -1:
        return ''
    else:
        return s[num] + reverse(num - 1)


# 第二题

def eval_rpn(new_list):
    new_list.pop(0)
    tmp = []
    op = {
        "+": lambda x, y: x + y,
        "-": lambda x, y: y - x,
        "*": lambda x, y: x * y,
        "/": lambda x, y: int(y / x)
    }
    for t in new_list:
        if t in op:
            tmp.append(op[t](tmp.pop(), tmp.pop()))
        else:
            tmp.append(int(t))
    return tmp.pop()


# 第三题
def sort_it(lists):
    if len(lists) <= 1:
        return lists
    num = int(len(lists) / 2)
    left = sort_it(lists[:num])
    right = sort_it(lists[num:])
    return merge(left, right)


def merge(left, right):
    r_num, l_num = 0, 0
    result = []
    while l_num < len(left) and r_num < len(right):
        if left[l_num] < right[r_num]:
            result.append(left[l_num])
            l_num += 1
        else:
            result.append(right[r_num])
            r_num += 1
    result += left[l_num:]
    result += right[r_num:]
    return result


# 第四题
word_list = [{
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


def filter_list():
    word_new = {}
    for item in word_list:
        serial = item["serial"]
        if serial not in word_new:
            word_new[serial] = item
    return list(word_new.values())


# 第五题
adcode_list = [
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

# 第五题
def tree(parent_str, tree_dict: dict, all_list):
    if all_list:
        if tree_dict:
            remove_list = []
            all_list_1 = all_list[:]
            for i in all_list_1:
                if "children" not in i:
                    i["children"] = []
                if i["parent"] == parent_str:
                    children_str = i["code"]

                    tree_filter, all_list = tree(children_str, i, all_list)
                    tree_dict = copy.deepcopy(tree_dict)
                    tree_dict["children"].append(tree_filter)
                    remove_list.append(i)
            for item in  remove_list:
                all_list.remove(item)


        else:
            for i in all_list:
                if i["parent"] == "":
                    if "children" not in i:
                        i["children"] = []
                    tree_dict = i
                    parent_str = i["code"]
                    all_list.remove(i)
                    tree_filter, all_list = tree(parent_str, tree_dict, all_list)
                    tree_dict = tree_filter
                break

        return tree_dict, all_list




if __name__ == '__main__':
    # 第一题
    s = "abcdefg"
    # s = reverse(len(s) - 1)
    # print(s)

    # 第二题
    # import sys
    # a = sys.argv
    # print(eval_rpn(a))
    # # python test.py 2 3 4 + *

    # 第三题
    # print(sort_it([3, 1, 4, 1, 5, 9, 2, 6]))

    # 第四题
    # print(filter_list())

    # 第五题
    # import copy
    # print(tree(None, {}, adcode_list)[0])
