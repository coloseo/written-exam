# 笔试题  

请完成以下笔试题，可以使用自己擅长的语言来编写，通过 github pull request 提交代码。

1. 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。

   ```Python
   def reverse(s):
       if len(s) == 0:
           return s
       else:
           return reverse(s[1:]) + s[0]
   
   
   s = "Geeksforgeeks"
   print(reverse(s))
   ```

2. 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令
    expr 2 3 4 + *

  ```Python
  RPN_str = 'expr 2 3 4 5 + * -'
  stack = []
  for c in RPN_str.split():
      if c in '+-*':
          i2 = stack.pop()
          i1 = stack.pop()
          print(i1, c, i2)
          print(eval('%s' * 3 % (i1, c, i2)))
          stack.append(eval('%s' * 3 % (i1, c, i2)))
      else:
          stack.append(c)
  print('result', stack[0])
  ```

3. 用归并排序将3，1，4，1，5，9，2，6 排序。

   ```Python
   def mergesort(seq):
       if len(seq) <= 1:
           return seq
       mid = len(seq) // 2
       left = mergesort(seq[:mid])
       right = mergesort(seq[mid:])
       return merge(left, right)
   
   
   def merge(left, right):
       result = []  
       i = 0  
       j = 0
       while i < len(left) and j < len(right):
           if left[i] <= right[j]:
               result.append(left[i])
               i += 1
           else:
               result.append(right[j])
               j += 1
       result += left[i:]
       result += right[j:]
       return result
   
   
   seq = [3, 1, 4, 1, 5, 9, 2, 6]
   result = mergesort(seq)
   print(result)
   ```

4. 对下面的 json 字符串 serial 相同的进行去重。

```javascript
  data_lists = [{
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
for data_list in data_lists:
    serial = data_list['serial']
    if serial not in serial_list:
        serial_list.append(serial)
        result.append(data_list)

print(result)
```

5. 把下面给出的扁平化json数据用递归的方式改写成组织树的形式

```javascript
  data = [
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
