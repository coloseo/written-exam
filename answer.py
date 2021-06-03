def reverse(s):
    if len(s)<1:
        return s
    return reverse(s[1:]) + s[0]


#TODO 2逆波兰表达式
class Stack():
    def __init__(self):
        self._stack = []

    def pop(self):
        return self._stack.pop()

    def push(self, s):
        return self._stack.append(s)

def calc(expr):
    symbol = {
        '+':lambda x,y: x + y,
        '-':lambda x,y: x - y,
        '^': lambda x, y: x ** y,
        '*': lambda x, y: x * y,
        '/': lambda x, y: x / y
    }
    s = Stack()
    for i in expr:
        if i in '+-*/^':
            x1,x2 = s.pop(),s.pop()
            res = symbol[i](float(x1), float(x2))
            s.push(res)
        else:
            s.push(i)

    return s.pop()

#TODO 3归并排序
def merge(left, right):
    result = []
    i = j = 0
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    result += left[i:]
    result += right[j:]
    return result

def merge_sort(lists):
    if len(lists)<=1:
        return lists

    middle = len(lists)//2
    left = merge_sort(lists[:middle])
    right = merge_sort(lists[middle:])
    return merge(left, right)

#TODO 4字典去重
def dict_set(sequence, par_name):
    '''根据列表中嵌套字典的value去重'''
    new_list = []
    new_dict = {}
    for i in range(len(sequence)):
        if not new_dict.__contains__(sequence[i][par_name]):
            new_dict[sequence[i][par_name]] = True
            new_list.append(sequence[i])
    return new_list

#TODO 5组织树型结构
class Tree():
    def __init__(self, id, name, code):
        self.id = id
        self.name = name
        self.code = code
        self.parent = None
        self.son = None

    def __str__(self):
        if self.parent:
            parent = self.parent.name
        else:
            parent = "无上一级"
        if self.son:
            print("id=%s, name=%s, 上级=%s"%(self.id, self.name, parent))
            for son in self.son:
                print(son)
            return "层级完毕"
        else:
            print("id=%s, name=%s,上级=%s" % (self.id, self.name, parent))
            return "层级完毕"

def get_tree(area):
    index = 0
    #判断id是否已将创建
    result = {}
    final_result = []
    if len(area)>0:
        for i in range(len(area)):
            son = []
            if area[i]['id'] not in result:
                A = Tree(area[i]['id'],area[i]['name'],area[i]['code'])
                result[area[i]['id']] = A
            else:
                A = result.get(area[i]['id'])
            for j in range(i+1, len(area)):
                if area[j]['parent'] == area[i]['code']:
                    if area[j]['id'] not in result:
                        B = Tree(area[j]['id'],area[j]['name'],area[j]['code'])
                        result[area[j]['id']] = B
                        son.append(B)
                        B.parent = A
                    else:
                        B = result[area[j]['id']]
                        son.append(B)

            A.son = son
            final_result.append(A)
    else:
        pass
    return final_result


def print_tree(area):
    area = get_tree(area)
    for i in area:
        if i.id == '1':
            print(i)
            break





if __name__ == "__main__":
    print(reverse('absc'))
    print(calc('234+*'))
    print(merge_sort([3,1,4,1,5,9,2,6]))
    a =   [{
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
    print(dict_set(a, 'serial'))

    area = [
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
    print_tree(area)
