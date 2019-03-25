
//  第一题
reverse = (str = '') => {
  return str.split('').reverse().join('');
}

//  第二题
expr = (arr = []) => {

  if (!arr) return 0;  //字符串为空,返回0

  var tempArr = arr.split(' ')
  var elems = [];

  let item = '';

  while (item = tempArr.shift) {
    if (!isNaN(+item)) {
      elems.push(+item)
    } else {
      var res = count(item, elems.pop, elems.pop)
      elems.push(res)
    }
  }
}

count = (opera, num1, num2) => {

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


//  第三题

mergeSort = () => {
  var arr = [3, 1, 4, 1, 5, 9, 2, 6];

  if (arr.length === 1)
    return arr;

  var mid = (a.length / 2), left = a.slice(0, mid), right = a.slice(mid);

  return merge(mergeSort(left), mergeSort(right));
}

merge = (left, right) => {

  while (left.length && right.length) {
    if (left[0] < right[0])
      tmp.push(left.shift());
    else
      tmp.push(right.shift());
  }

  return tmp.concat(left, right);
}


//  第四题
unique = () => {
  let arr = [{
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
  let newArr = [];
  for (let item of arr) {
    const { serial = '' } = item;
    const aaa = newArr.find(item => item.serial === serial);
    if (!aaa) {
      newArr.push(item);
    }
  }
  return newArr;
}

//  第五题

var tree = [
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

transDate = (tree, idstr = 'id', pidstr = 'parent') => {
  let result = [], temp = {};
  for (i = 0; i < tree.length; i++) {
    temp[tree[i][idstr]] = tree[i];
  }
  for (j = 0; j < tree.length; j++) {
    tempVp = temp[tree[j][pidstr]];
    if (tempVp) {
      if (!tempVp["nodes"]) tempVp["nodes"] = [];
      tempVp["nodes"].push(tree[j]);
    } else {
      result.push(tree[j]);
    }
  }
  return result;
} 