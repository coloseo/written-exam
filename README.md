# 笔试题  

请完成以下笔试题，可以使用自己擅长的语言来编写，通过 github pull request 提交代码。

1. 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
```javascript
    def reverse(s):
        if s == '':
            return s
        else:
            return (s[1:]) + s[0]
```


2. 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令
expr 2 3 4 + *
```javascript
    def caculate(oper, x, y):
        if oper== '+' :
                return x+y
        if oper== '-' :
                return x-y
        if oper== '*' :
                return x*y
        if oper== '/' :
                return x/y
       
    def evalRPN(tokens):
        if (len(tokens) == 0):
            return 0;
        tokens_s = []
        result = 0
        i = 0;
        x = 0
        y = 0
        for i in range(0,len(tokens)):
            element = tokens[i] 
            if ((element== "+") or (element== "-") or (element== "*") or (element== "/")):
                y = tokens_s.pop()
                x = tokens_s.pop()
                tokens_s.append(int(caculate(element,int(x),int(y))))
            else:
                tokens_s.append(int(element))
        return (int)(tokens_s.pop())
    tokens =  []#test
    print(evalRPN(tokens))
    tokens =  ["2", "3", "4", "＋", "*"]
```


3. 用归并排序将3，1，4，1，5，9，2，6 排序。
```javascript
    def merge_sort(items, comp=lambda x, y: x <= y):
         if len(items) < 2:
             return items[:]
         mid = len(items) // 2
         left = merge_sort(items[:mid], comp)
         right = merge_sort(items[mid:], comp)
         return merge(left, right, comp)
         
         
     def merge(items1, items2, comp):
     items = []
     index, index2 = 0, 0
     while index1 < len(items1) and index2 < len(items2):
         if comp(items1[index1], items2[index2]):
             items.append(items1[index1])
             index1 += 1
         else:
             items.append(items2[index2])
             index2 += 1
     items += items1[index1:]
     items += items2[index2:]
     return items
```

4. 对下面的 json 字符串 serial 相同的进行去重。
```javascript
    dict_list = [{'a':100,'b':101},{'a':103,'b':104},{'a':105,'b':101}]#假设是下面的列表
    data_list = []
    for item in dict_list:
        for key, value in item.items():
            if value not in data_list:
                data_list.append(value)
            else:
                dict_list.remove(item)
    print(dict_list)
```

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

5. 把下面给出的扁平化json数据用递归的方式改写成组织树的形式
```javascript
    list_tree = []
    # 重新排序
    def list_order(pid,list):
        for x in list:
            if pid == x['parent_id']:
                list_tree.append(x)
                list_order(x['id'],list)
                 
    list_order(0,list)
     
    for x in list_tree:
        print(x['title'])
    ＃这道题还没有完全理解，请见谅
```

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

