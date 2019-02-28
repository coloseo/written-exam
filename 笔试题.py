
# 一、编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。

w = input("请输入需要反转的字符串：")
r = ''
def reverse(s):
    global r
    if len(s) <= 1:
        return r + s
    r += s[-1]
    S = s[:len(s)-1]
    return  reverse(S)
print("字符的反转结果为：",reverse(w))



#===============================================================================================================================#


# 二、编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *
# expr.py
import sys

stack = []
exp_list = sys.argv[1:]

def cac():
    try:
        for n in exp_list:
            if n in '+-*/':
                i2 = stack.pop()
                i1 = stack.pop()
                stack.append(str(eval(i1 + n + i2)))
            else:
                stack.append(n)
        print('最终结果为：',stack.pop())
    except Exception as e:
        print('出现错误：',e)

cac()





#===============================================================================================================================#


# 三、用归并排序将3，1，4，1，5，9，2，6 排序。

def merge(a, b):
    c = []
    d = e = 0
    while d < len(a) and e < len(b):
        if a[d] < b[e]:
            c.append(a[d])
            d += 1
        else:
            c.append(b[e])
            e += 1

    if d == len(a):
        for i in b[e:]:
            c.append(i)
    else:
        for i in a[d:]:
            c.append(i)

    return c


def sortlist(lists):
    if len(lists) <= 1:
        return lists
    middle = len(lists)//2
    left = sortlist(lists[:middle])
    right =sortlist(lists[middle:])
    return merge(left, right)


if __name__ == '__main__':
    a = [3,1,4,1,5,9,2,6]
    print(sortlist(a))


#===============================================================================================================================#


# 四、对下面的json字符串serial相同的进行去重。
# [{
#     "name": "张三",
#     "serial": "0001"
# }, {
#     "name": "李四",
#     "serial": "0002"
# }, {
#     "name": "王五",
#     "serial": "0003"
# }, {
#     "name": "王五2",
#     "serial": "0003"
# }, {
#     "name": "赵四",
#     "serial": "0004"
# }, {
#     "name": "小明",
#     "serial": "005"
# }, {
#     "name": "小张",
#     "serial": "006"
# }, {
#     "name": "小李",
#     "serial": "006"
# }, {
#     "name": "小李2",
#     "serial": "006"
# }, {
#     "name": "赵四2",
#     "serial": "0004"
# }];



import pymongo
import bson


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



def remove():
    client = pymongo.MongoClient('mongodb://localhost:27017/')
    db = client.duprm
    col = db.rm
    col.insert_many(data)

    col.aggregate([{
            '$group':{'_id':'$serial','count':{'$sum':1},'dups':{'$addToSet':'$_id'}}
    },
        {
            '$match':{'count':{'$gt':1}}
    }]).forEach(function(item){
         item.dups.shift();
         col.remove({'_id': {'$in': item.dups}});

    });

    for one in col.find({'name':{'$regex':"2"}}):
        one['name'] = one['name'].replace('2','')
        col.update({'name':{'$regex':"2"}},{'$set':one})

    print(bson.json_util.dumps(list(col.find())))


if __name__ == '__main__':
    remove()



#===============================================================================================================================#


# 五、 把下面给出的扁平化json数据用递归的方式改写成组织树的形式
#
  # [
  #   {
  #     "id": "1",
  #     "name": "中国",
  #     "code": "110",
  #     "parent": ""
  #   },
  #   {
  #     "id": "2",
  #     "name": "北京市",
  #     "code": "110000",
  #     "parent": "110"
  #   },
  #   {
  #     "id": "3",
  #     "name": "河北省",
  #     "code": "130000",
  #     "parent": "110"
  #   },
  #   {
  #     "id": "4",
  #     "name": "四川省",
  #     "code": "510000",
  #     "parent": "110"
  #   },
  #   {
  #     "id": "5",
  #     "name": "石家庄市",
  #     "code": "130001",
  #     "parent": "130000"
  #   },
  #   {
  #     "id": "6",
  #     "name": "唐山市",
  #     "code": "130002",
  #     "parent": "130000"
  #   },
  #   {
  #     "id": "7",
  #     "name": "邢台市",
  #     "code": "130003",
  #     "parent": "130000"
  #   },
  #   {
  #     "id": "8",
  #     "name": "成都市",
  #     "code": "510001",
  #     "parent": "510000"
  #   },
  #   {
  #     "id": "9",
  #     "name": "简阳市",
  #     "code": "510002",
  #     "parent": "510000"
  #   },
  #   {
  #     "id": "10",
  #     "name": "武侯区",
  #     "code": "51000101",
  #     "parent": "510001"
  #   },
  #   {
  #     "id": "11",
  #     "name": "金牛区",
  #     "code": "51000102",
  #     "parent": "510001"
  #   }
  # ];


list = [
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

list_tree = []


def list_order(pid, list):
    for x in list:
        if pid == x['parent']:
            list_tree.append(x)
            list_order(x['code'], list)


list_order('', list)

print(list_tree)