#填写人：廖文君   应聘职位：后端开发工程师   编程语言：Python

# 笔试题

请完成以下笔试题，可以使用自己擅长的语言来编写，通过 github pull request 提交代码。

1. 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。


def func(s):
    if s:
        return func(s[1:]) + s[0]
    else:
        return s


def main():
    s = 'vera'
    print(func(s))


if __name__ == '__main__':
    main()


2. 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令
expr 2 3 4 + *


def calc_result(str1):
    nums = []
    for i in str1[5:].split():
        if i in ['+', '-', '*', '/']:
            first, second = nums.pop(), nums.pop()
            nums.append(str(eval(second + i + first)))
        else:
            nums.append(i)
    return eval(nums.pop()) if nums else 0


def main():
    str1 = 'expr 2 3 4 + *'
    print(calc_result(str1))


if __name__ == '__main__':
    main()


3. 用归并排序将3，1，4，1，5，9，2，6 排序。


def merge(items1, items2, comp=lambda x, y: x <= y):
    index1, index2 = 0, 0
    items3 = []
    while index1 < len(items1) and index2 < len(items2):
        if comp(items1[index1], items2[index2]):
            items3.append(items1[index1])
            index1 += 1
        else:
            items3.append(items2[index2])
            index2 += 1
    items3 += items2[index2:]
    items3 += items1[index1:]
    return items3


def merge_sort(items, comp=lambda x, y: x <= y):
    if len(items) < 2:
        return items[:]
    mid = len(items) // 2
    left = merge_sort(items[:mid], comp)
    right = merge_sort(items[mid:], comp)
    return merge(left, right, comp)


def main():
    items = [3, 1, 4, 1, 5, 9, 2, 6]
    print(merge_sort(items))


if __name__ == '__main__':
    main()


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


items3=[{"name": "张三","serial": "0001"},\
 {"name": "李四","serial": "0002"}, {"name": "王五","serial": "0003"},\
  { "name": "王五2","serial": "0003"}, {"name": "赵四","serial": "0004"},\
   {"name": "小明","serial": "005"}, {"name": "小张","serial": "006"},\
    {"name": "小李","serial": "006"}, {"name": "小李2",\
    "serial": "006"}, {"name": "赵四2","serial": "0004"}]


items4=[]
items4.append(items3[0])
for item3 in items3:
    k=0
    for item4 in items4:
        if item4['serial'] != item3['serial']:
            k=k+1
        else:
            break
        if k == len(items4):
            items4.append(item3)
print(items4)


5. 把下面给出的扁平化json数据用递归的方式改写成组织树的形式

```javascript
  [
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
  ];
```

items=[
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


def func(it, items):
    for index, item in enumerate(items):
        if it['parent'] == item['code']:
            it['parent'] = item
            if item['parent']:
                func(item, items)


def main():
    for i in items:
        func(i, items)
    return items[1:]


if __name__ == '__main__':
    main()