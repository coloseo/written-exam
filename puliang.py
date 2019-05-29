# 请完成以下笔试题，可以使用自己擅长的语言来编写，通过 github pull request 提交代码。
# 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
"""
1.递归返回条件，列表长度为1时
2.获取列表最后一个元素
"""


def test_reverses(s):
    if len(s) == 1:
        return s.pop()  # 列表只有一个元素返回
    if len(s) > 1:
        return s.pop() + test_reverses(s)  # 取列表最后一个元素


s = 'dasudhashdfg'
print((test_reverses(list(s))))

# 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。
# 例如，命令 expr 2 3 4 + *
"""

"""

# 用归并排序将3，1，4，1，5，9，2，6 排序。

"""
1.归并采用递归算法，将数据表持续一分为2，对两边分别进行归并排序
2.递归返回条件，数据表只有一项，而且是排序好的
"""
llist = [3, 1, 4, 1, 5, 9, 2, 6]


def mergesort(llist):
    if len(llist) <= 1:  # 数据表只有1项的时候返回
        return llist
    middle = int(len(llist) / 2)  # 得到数据表长度的中间值
    left = mergesort(llist[:middle])  # 左边的数据表
    right = mergesort(llist[middle:])  # 右边的数据表
    merged = []
    while left and right:
        merged.append(left.pop(0) if left[0] < right[0] else right.pop(0))  # 进行排序
    merged.extend(right if right else left)
    return merged


print(mergesort(llist))
# 对下面的 json 字符串 serial 相同的进行去重。

"""
1.取所有的数据的下标
2.比较他们的‘serial’是否相等，相等则去掉
"""

data = [{
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

i = 0
while i < len(data):
    j = i + 1
    while j < len(data):
        if data[i]['serial'] == data[j]['serial']:
            data.pop(j)
            j -= 1
        j += 1
    i += 1
print(data)
# 把下面给出的扁平化json数据用递归的方式改写成组织树的形式

"""
1.根据"parent"和code直接关系判断父节点
2.递归的思想形成一棵树，先找到根节点然后逐一向下查找。

"""
data = [
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


def printList(parentId, data, spaceStr=''):
    for x in data:
        if x['parent'] == parentId:
            print(spaceStr, x['name'], sep='')
            printList(x['code'], data, spaceStr + ' ')


printList('', data)
