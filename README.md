（1）
def reverse(s):
    if s == '':
        return s
    else:
        return reverse(s[1:]) + s[0]

print(reverse('abcde'))

（2）
def expr(data):
    stack_res = list()
    cal = ['+', '-', '*', '/']

    for index in data:
        if index not in cal:
            stack_res.append(index)

        else:
            right = int(stack_res.pop())
            left = int(stack_res.pop())

            if index == '*':
                res = left * right
                stack_res.append(res)
            if index == '/':
                res = left / right
                if right_ops == 0:
                    raise Exception('Zero')
                stack_res.append(res)
            if index == '+':
                res = left + right
                stack_res.append(res)
            if index == '-':
                res = left - right
                stack_res.append(res)

    if len(stack_res) == 1:
        return stack_res[0]

print('输入参数')
date = input().split()
print(expr(date))

（3）
def MergeSort(date):
    if len(date) <= 1:
        return date
    i = int( len(date) / 2 )
    left = MergeSort(date[:i])
    right = MergeSort(date[i:])
    return Merge(left, right)
def Merge(left,right):
    r, l=0, 0
    result=[]
    while l<len(left) and r<len(right):
        if left[l] <= right[r]:
            result.append(left[l])
            l += 1
        else:
            result.append(right[r])
            r += 1
    result += list(left[l:])
    result += list(right[r:])
    return (result)

if __name__ == '__main__':
    print (MergeSort([3,1,4,1,5,9,2,6]))
    
（4）
json = [{"name": "张三","serial": "0001"}, {"name": "李四","serial": "0002"},
        {"name": "王五","serial": "0003"}, {"name": "王五2","serial": "0003"},
        {"name": "赵四","serial": "0004"}, {"name": "小明","serial": "005"},
        { "name": "小张", "serial": "006"}, {"name": "小李","serial": "006" },
        { "name": "小李2", "serial": "006" }, { "name": "赵四2","serial": "0004"}];\
p = list()
q = list()
for i in json:
    p.append(i["serial"])
j = len(p) - 1
while range(j):
    if p[j] not in p[:j]:
        q.append(json[j])
    j = j - 1
q.append(json[0])
print(q)

（5）
json=[
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

def getChildren(parent=""):
    children=[]
    for obj in json:
        if obj["parent"] == parent:
            children.append({"id":obj["id"],"name":obj["name"],"code":obj["code"],"parent":obj["parent"],"children":getChildren(obj["code"])})
    return children
if __name__ == '__main__':
    print(getChildren())
