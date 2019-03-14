# 笔试题  陈宇航

请完成以下笔试题，可以使用自己擅长的语言来编写，通过 github pull request 提交代码。

1. 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。

   ```
   def string_reverse(string):
       if len(string) <= 1:
           return string
       return string_reverse(string[1:]) + string[0]
   
   
   string = 'cyh'
   
   print(string_reverse(string))
   ```

2. 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令
  expr 2 3 4 + *

  ```
   class Solution:
        def evalRPN(self, tokens):
            stack = []
            for i in range(0, len(tokens)):
                if tokens[i] != '+' and tokens[i] != '-' and tokens[i] != '*' and tokens[i] != '/':
                    stack.append(int(tokens[i]))
                else:
                    a = stack.pop()
                    b = stack.pop()
                    if tokens[i] == '+':
                        stack.append(a + b)
                    if tokens[i] == '-':
                        stack.append(b - a)
                    if tokens[i] == '*':
                        stack.append(a * b)
                    if tokens[i] == '/':
                        if a * b < 0:
                            stack.append(-((-b) / a))
                        else:
                            stack.append(b / a)
            return stack.pop()
  ```

3. 用归并排序将3，1，4，1，5，9，2，6 排序。

   ```
   def merge_sort(li):
       if len(li) <= 1:
           return li
       mid = len(li) // 2
   
       left = li[:mid]
       right = li[mid:]
   
       left = merge_sort(left)
       right = merge_sort(right)
   
       return merge(left, right)
   
   
   def merge(left, right):
       c = []
       h = j = 0
       while j < len(left) and h < len(right):
           if left[j] < right[h]:
               c.append(left[j])
               j += 1
           else:
               c.append(right[h])
               h += 1
   
       if j == len(left):
           for i in right[h:]:
               c.append(i)
       else:
           for i in left[j:]:
               c.append(i)
   
       return c
   
   
   if __name__ == '__main__':
       a = [3, 1, 4, 1, 5, 9, 2, 6]
       print(merge_sort(a))
   
   ```

4. 对下面的 json 字符串 serial 相同的进行去重。

   ```
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


```javascript
  lists =   [{
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
serial_list = []
result = []
for data_list in lists:
	serial = data_list['serial']
	if serial not in serial_list:
		serial_list.append(serial)
		result.append(data_list)
		
print(result)

```

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

```
data =  [
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

list_tree = []

def list_order(pid, list, frist=None):
    for x in list:
        if not x['parent'] and frist is None:
            list_tree.append(x)
            if pid == x['parent']:
                list_tree.append(x)
                list_order(x['code'], list, frist=1)


list_order('110', data)
print(list_tree)
```

