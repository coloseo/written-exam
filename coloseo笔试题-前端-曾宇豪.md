###1、编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
~~~
function  reverse(s)  {
    return s.length > 1 ?
    reverse(s.slice(1)).concat(s.slice(0, 1)) : s;
}
~~~

###2、编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *

~~~
function calc(expr) {
  if (!expr) return 0;    
  var arr = expr.split(' ')
  var elems = []  
  var item;
  
  while (item = arr.shift()) { 
    if (!isNaN(+item)) {  
      elems.push(+item)
    } else {
      var res = count(item, elems.pop(), elems.pop())
      elems.push(res)
    }
  }
  
  //  运算符计算
  function count (opera, num1, num2) {
    
    switch (opera) {
      case '+':
        return num2 + num1
      case '-':
        return num2 - num1
      case '*':
        return num2 * num1
      case '/':
        return num2 / num1
    }
  }  
  return elems.pop()  
}
~~~

###3、用归并排序将3，1，4，1，5，9，2，6 排序。
~~~
function mergeSort(s) {
    if (s.length<=1){
        return s;
    }
    let mid=Math.floor(s.length/2);
    let left_s=s.slice(0,mid);
    let right_s=s.slice(mid);
    return merge(mergeSort(left_s),mergeSort(right_s));
}
function merge(left, right) {
    let result=[];
    while (left.length>0&&right.length>0){
        if (left[0]<right[0]){
            result.push(left.shift());
        }else {
            result.push(right.shift());
        }
    }
    return result.concat(left).concat(right);
}
~~~

###4、对下面的 json 字符串 serial 相同的进行去重。
~~~
let arr =  [{
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

  var hash = {};
  arr = arr.reduce(function(item, next) {
      hash[next.serial] ? '' : hash[next.serial] = true && item.push(next);
      return item
  }, [])
 ~~~

###5、把下面给出的扁平化json数据用递归的方式改写成组织树的形式
 var list=[
    {
      "id": "1",
      "name": "中国",
      "code": "110",
      "parent": null
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

  function filterArray(data, parent) {    
    var tree = [];
    var temp;
    for (let i = 0; i < data.length; i++) {
        if (data[i].parent == parent) {
            var obj = data[i];
            temp = filterArray(data, data[i].code);
            if (temp.length > 0) {
                obj.subs = temp;
            }
            tree.push(obj);
        }
    }
    return tree;
}
 filterArray(list)
~~~

