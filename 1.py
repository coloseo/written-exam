# 翻转字符串
def reverse(s):
    print(s[::-1])


reverse("superhero")


# 逆波兰表达式

def expr(s):
    t = []
    for x in s[::1]:
        if x in ["+", "-", "*", "/"]:
            f, s = t.pop(), t.pop()
            t.append(s + x + f)
        else:
            t.append(x)
    return t.pop()


print(expr("234+*"))


# 归并排序3， 1， 4， 1， 5， 9， 2， 6

def merge(l1):
    if len(l1) > 1:
        low = []
        equal = []
        high = []
        for x in l1:
            if x > l1[0]:
                high.append(x)
            elif x < l1[0]:
                low.append(x)
            else:
                equal.append(x)
        # print(low, equal, high)
        return merge(low) + equal + merge(high)
    return l1


print(merge([3, 1, 4, 1, 5, 9, 2, 6]))


# 对下面的 json 字符串 serial 相同的进行去重。

a = [{
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
for x in range(len(a)):
    for i in range(x):
        if a[x].get("serial") == a[i].get("serial"):
            del a[i]["serial"]
print(a)