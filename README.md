# 笔试题  

请完成以下笔试题，可以使用自己擅长的语言来编写，通过 github pull request 提交代码。

1. 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。

```python
def reverse_str(s:str):
    if len(s) <= 1:
        return s
    return s[-1] + reverse_str(s[:-1])


def main():
    result = reverse_str('hello world')
    print(result)


if __name__ == '__main__':
    main()
```



2. 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令expr 2 3 4 + *

```python
def reverse_polish_expression():
    """
    逆波兰表达式
    """
    stack_value = []
    for item in input().split(' '):
        if item in ['+', '-', '*', '/']:
            n2 = stack_value.pop()
            n1 = stack_value.pop()
            result = cal(n1, n2, item)
            stack_value.append(result)
        else:
            stack_value.append(int(item))
    return stack_value[0]


def cal(n1, n2, op):
    if op == '+':
        return n1 + n2
    if op == '-':
        return n1 - n2
    if op == '*':
        return n1 * n2
    if op == '/':
        return n1 / n2
    
    
def main():
    result = reverse_polish_expression()
    print(result)


if __name__ == '__main__':
    main()
```



3. 用归并排序将3，1，4，1，5，9，2，6 排序。

```python
def merge_sort(items, comp=lambda x, y: x <= y):
    """
    归并排序
    """
    if len(items) < 2:
        return items[:]
    mid = len(items) // 2
    left = merge_sort(items[:mid])
    right = merge_sort(items[mid:])
    return merge(left, right)


def merge(items1, items2, comp=lambda x, y: x <= y):
    """合并：将两个有序列表合并成一个新的有序列表"""
    index1, index2 = 0, 0
    result = []
    while index1 < len(items1) and index2 < len(items2):
        if comp(items1[index1], items2[index2]):
            result.append(items1[index1])
            index1 += 1
        else:
            result.append(items2[index2])
            index2 += 1
    result += items1[index1:]
    result += items2[index2:]
    return result


def main():
    result = merge_sort([3, 1, 4, 1, 5, 9, 2, 6])
    print(result)


if __name__ == '__main__':
    main()

```



4. 对下面的 json 字符串 serial 相同的进行去重。

```javascript
  [{
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
  }];

```

```python
import json


def remove_duplicates(items):
    items = json.loads(items)
    result = []
    duplicates_list = []
    for item in items:
        if item['serial'] not in duplicates_list:
            duplicates_list.append(item['serial'])
            result.append(item)
    return result

def main():
    result = remove_duplicates(item)
    print(result)


if __name__ == '__main__':
    main()
```



5. 把下面给出的扁平化json数据用递归的方式改写成组织树的形式

```javascript
  [
    {
      "id": "1",
      "name": "中国",
      "code": "110",
      "parent": "",
    },
    {
      "id": "2",
      "name": "北京市",
      "code": "110000",
      "parent": "110",
    },
    {
      "id": "3",
      "name": '河北省',
      "code": '130000',
      "parent": '110',
    },
    {
      "id": "4",
      "name": "四川省",
      "code": "510000",
      "parent": "110",
    },
    {
      "id": "5",
      "name": "石家庄市",
      "code": "130001",
      "parent": "130000",
    },
    {
      "id": "6",
      "name": "唐山市",
      "code": "130002",
      "parent": "130000",
    },
    {
      "id": "7",
      "name": "邢台市",
      "code": "130003",
      "parent": "130000",
    },
    {
      "id": "8",
      "name": "成都市",
      "code": "510001",
      "parent": "510000",
    },
    {
      "id": "9",
      "name": "简阳市",
      "code": "510002",
      "parent": "510000",
    },
    {
      "id": "10",
      "name": "武侯区",
      "code": "51000101",
      "parent": "510001",
    },
    {
      "id": "11",
      "name": "金牛区",
      "code": "51000102",
      "parent": "510001",
    },
  ];
```

```python
import json


result = []
def organization_tree_form(items, code='', flag=False):
    items = json.loads(items)
    for item in items:
        if not item['parent'] and not flag:
            code = item['code']
            result.append(item)

        elif code == item['parent']:
            for result_item in result:

                if result_item['code'] == code:
                    if not result_item.get('child'):
                        result_item['child'] = []
                        result_item['child'].append(item)
                    else:
                        result_item['child'].append(item)
    for result_item in result[0]['child']:
        organization_tree_form(items, code=result_item['code'], flag=True)

organization_tree_form(items, code='110')
print(result)
```

