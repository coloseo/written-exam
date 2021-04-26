"""
李陈冬
"""

def reverse(s):
    """
    编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置
    """
    if(len(s) == 0 or len(s) == 1):
        return s
    else:
        return reverse(s[1:]) + s[0]


def expr():
    """
    编写程序 expr，以计算从命令行输入的逆波兰表达式的值，
    其中每个运算符或操作数用一个单独的参数表示。
    例如，命令 expr 2 3 4 + *
    """
    def calculation(symbol, firstNum, secondNum):
        if symbol == '+':
            return float(firstNum) + float(secondNum)
        elif symbol == '-':
            return float(firstNum) - float(secondNum)
        elif symbol == '*':
            return float(firstNum) * float(secondNum)
        elif symbol == '/':
            return float(firstNum) / float(secondNum)

    import sys
    formula = ' '.join(sys.argv[2:])

    stack = []
    for item in formula.split():
        if item in ('+','-','*','/'):
            firstNum, secondNum = stack.pop(), stack.pop()
            # print(calculation(item, secondNum, firstNum))
            stack.append(calculation(item, secondNum, firstNum))
        else:
            stack.append(item)
            # print(stack)

    return stack[0] if stack else 0


def merge_sort(numList = [3, 10, 4, 1, 5, 9, 2, 6]):
    """
    归并排序
    """
    def merge(frontList, behindList, numList):
        """根据两边的列表， 对原来列表进行排序"""

        # frontIndex指前半部分索引
        frontIndex, behindIndex = 0, 0
        while frontIndex + behindIndex < len(numList):
            # 当后半部分走完了，或者前半部分没走完并且前半部分这个位置是最小的
            if behindIndex == len(behindList) or (frontIndex < len(frontList) and frontList[frontIndex] < behindList[behindIndex]):
                numList[frontIndex + behindIndex] = frontList[frontIndex]
                frontIndex += 1
            else:
                numList[frontIndex + behindIndex] = behindList[behindIndex]
                behindIndex += 1
        
        return numList

    listLength = len(numList)
    if listLength < 2:
        return numList

    midIndex = listLength // 2
    frontList = numList[0 : midIndex]
    behindList = numList[midIndex : listLength]

    merge_sort(frontList)
    merge_sort(behindList)

    # 合并
    numList = merge(frontList, behindList, numList)
    return numList


def json_duplicate_remova():
    """
    对下面的 json 字符串 serial 相同的进行去重。
    """
    import json

    jsonStrs = """
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
                }]
            """

    listObjs = json.loads(jsonStrs)
    newListObjs  = []
    serialCountList = []

    for eachDict in listObjs:
        if eachDict.get("serial") not in serialCountList:
            serialCountList.append(eachDict.get("serial"))
            newListObjs.append(eachDict)

    return newListObjs


def create_tree(code, data):
    """
    把扁平化json数据用递归的方式改写成组织树的形式
    """
    result = []
    for item in data:
        if code == item["parent"]:
            result.append(item)
            item["child"] = create_tree(item["code"], data)
    return result



def run():
    # 第一题
    print(reverse('asdfa'))

    # 第二题
    print(expr())

    # 第三题
    print(json_duplicate_remova())

    # 第四题
    print(merge_sort())

    # 第五题
    import json
    json_string = """
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
            ]
            """
    obj = json.loads(json_string)
    print(json.dumps(create_tree("", obj), ensure_ascii = False))


if __name__ == "__main__":
    run()
