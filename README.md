# 笔试题  

请完成以下笔试题，可以使用自己擅长的语言来编写，通过 github pull request 提交代码。

1. 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
```javascript
function reverse(s){
    if(s.length === 1){
        return s[0];
    }else{
        return reverse(s.substr(1,s.length-1)) + s[0];
    }
}
reverse('just a test string');
```

2. 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令
expr 2 3 4 + *
```javascript
function expr(...args){
    let stack = [];
    for(let arg of args){
        let type,tmp = Number(arg);
        const NUM = 'num', OPERATOR = 'operator';
        if(isNaN(tmp)){
            type = OPERATOR;
        }else{
            type = NUM;
            arg = tmp;
        }
        if(type === NUM){
            stack.push(arg);
        }else if(type === OPERATOR){
            let n1 = stack.splice(stack.length-1,1);
            let n2 = stack.splice(stack.length-1,1);
            stack.push(eval(`${n1}${arg}${n2}`));
        }
    }
    return stack[0];
}
expr(2,3,4,'+','*')
```

3. 用归并排序将3，1，4，1，5，9，2，6 排序。
```javascript
function mergeSort(arr = [],ascending = true){
    if(arr.length === 1){
        return arr;
    }else{
        return mergeArr(mergeSort(arr.splice(0,arr.length/2)),mergeSort(arr),ascending);
    }
}

function mergeArr(arr1 = [],arr2 = [],ascending = true){
    let ans = [];
    while(arr1.length>0 || arr2.length>0){
        if(arr2.length===0  || arr1[0]< arr2[0] ){
            ans.push(arr1[0]);
            arr1.splice(0,1);
        }else{
            ans.push(arr2[0]);
            arr2.splice(0,1);
        }
    }
    if(ascending === false){
        return ans.reverse();
    }else{
        return ans;
    }
}
mergeSort([3,1,4,1,5,9,2,6])
```

4. 对下面的 json 字符串 serial 相同的进行去重。

```javascript
  let json_1 = [{
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

function unique(jsonArr){
    let book = {};
    for(let i = 0;i<jsonArr.length;i++ ){
        let serial = jsonArr[i].serial;
        if(book.hasOwnProperty(serial)){
            jsonArr.splice(i--,1);
        }else{
            book[serial] = true;
        }
    }
    return jsonArr;
}
unique(json_1);
```
5. 把下面给出的扁平化json数据用递归的方式改写成组织树的形式

```javascript
  let json_2 = [
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

function parseTree(jsonArr){
    let ans= {};
    for(let i in jsonArr){
        let node = jsonArr[i];
        ans[node.code] = node;
    }
    for(let code in ans){
        mergeSon(ans,code);
    }
    return ans;
}
    
function mergeSon(ans,code){
    let node = ans[code];
    for(let i in ans){
        let p = ans[i];
        if(p.parent === code){
            mergeSon(ans,p.code);
            if(!node.hasOwnProperty('child')){
                node.child = {};
            }
            node.child[p.code] = p;
            delete ans[p.code];
        }
    }
}
parseTree(json_2);
```
