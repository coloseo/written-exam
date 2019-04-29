// 1. 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
function reverse(s) {
    if (typeof s !== 'string') return;
    if (s.length <= 1) return s;
    return reverse(s.slice(1)) + s.charAt(0);
}

console.log(reverse('asdj123'));

// 2 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *
var expStr = '2 3 4 + *';
function calc(oprator, num1, num2) {
    switch(oprator) {
        case '+': return num1 + num2;
        case '-': return num1 - num2;
        case '*': return num1 * num2;
        case '/': return num1 / num2;
    }
}
function expr(expStr) {
    var expArr = expStr.split(' ');
    var numbers = [];
    for (var i = 0; i < expArr.length; i++) {
        if (!isNaN(parseInt(expArr[i], 10))) {
            numbers.push(parseInt(expArr[i], 10));
        } else {
            var num = calc(expArr[i], numbers.pop(), numbers.pop());
            numbers.push(num);
        }
    }
    return numbers.pop();
}
console.log(expr(expStr));

// 3用归并排序将3，1，4，1，5，9，2，6 排序。
var arr = [3, 1, 4, 1, 5, 9, 2, 6];

function merge(leftArr, rightArr) {
    var res = [];
    while ( leftArr.length > 0 && rightArr.length > 0) {
        if (leftArr[0] <= rightArr[0]) {
            res.push(leftArr.shift());
        } else {
            res.push(rightArr.shift());
        }
    }
    return res.concat(leftArr).concat(rightArr);
}

function mergeSort(arr) {
    if (arr.length <= 1) return arr;
    var mid = Math.floor(arr.length / 2);
    return merge(mergeSort(arr.slice(0, mid)), mergeSort(arr.slice(mid)));
}

console.log(mergeSort(arr));

// 4对下面的 json 字符串 serial 相同的进行去重。
var test = [
    {
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

function unique(arr) {
    var res = [];
    var temp = [];
    for (var i = 0; i < arr.length ; i++) {
        var serial = arr[i].serial;
        // 如果临时数组已包含该serial，说明重复不进行处理
        if (temp.indexOf(serial) != -1) {
            continue;
        } else {
            temp.push(serial);
            res.push(arr[i]);
        }
    }
    return res;
}

console.log(unique(test));

// 5把下面给出的扁平化json数据用递归的方式改写成组织树的形式
var testJson = [
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
function json2tree(testJson) {
    var temp = {};
    var tree = {};
    for (var i = 0; i < testJson.length; i++) {
        temp[testJson[i].code] = testJson[i];
    }
    for (var j in temp) {
        if (temp[j].parent) { // 有无父节点
            if (!temp[temp[j].parent].children) { // 当前节点父节点有无children
                temp[temp[j].parent].children = [];
            }
            var obj = {};
            obj[temp[j].code] = temp[j];
            temp[temp[j].parent].children.push(obj); // 将子节点添加到父节点下
        } else {
            tree[temp[j].code] = temp[j];
        }
    }
    return tree;
}
console.log(json2tree(testJson));