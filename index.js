//第一题:
function reverse(arr,len,a){
    if(len>=1){ 
       let temp = arr.shift();  
       a[len-1] = temp;
       len=len-1;
       reverse(arr,len,a);
    }
    return a;
}
function handleRes(s){
    let arr = s.split('');
    let len = arr.length;
    let a = [];
    let answer = reverse(arr,len,a).join('');
    console.log(answer);
    return answer;
}

//第二题
expr = (arr = []) => {
    if (!arr) return 0; 
    var tempArr = arr.split(' ')
    console.log(tempArr)
    var elems = [];
    let item = '';
     while (item = tempArr.shift()) {
       if (!isNaN(item)) {
        elems.push(item)
      } else {
        var a = elems.shift()
        var b = elems.shift()
        var res = count(item, a, b)
         elems.push(res)
       }
     }
    console.log(elems)
  }
  
  count = (opera, num1, num2) => {
    switch (opera) {
      case '+':
        return parseInt(num2)  + parseInt(num1)
      case '-':
        return parseInt(num2)  - parseInt(num1)
      case '*':
        return parseInt(num2)  * parseInt(num1)
      case '/':
        return parseInt(num2)  / parseInt(num1)
    }
  }

   expr('2 3 4 + *')

//第三题
function Merger(a, b){
    var n = a && a.length;
    var m = b && b.length;
    var c = [];
     var i = 0, j = 0;

    while (i < n && j < m)
     {
         if (a[i] < b[j])
             c.push(a[i++]);
         else
             c.push(b[j++]); 
     }

     while (i < n)
         c.push(a[i++]);

     while (j < m)
         c.push(b[j++]); 

    
    return c;
}

function merge_sort(arr){
    
    if(arr.length == 1)
        return arr

    var mid = Math.floor(arr.length/2)
    var left = arr.slice(0,mid)
    var right = arr.slice(mid)

    return Merger(merge_sort(left),merge_sort(right)); //合并左右部分
}
var a = [3,1,4,1,5,9,2,6]
console.log(merge_sort(a))
//第四题

function getonly() {
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

console.log(getonly())
//第五题


let tree = [
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


function Tree(s){
  let ind = 0 ;
  if(s.length>1){
      for(let i=0;i<s.length;i++){
          let a = 0;  
          for(let j=i+1;j<s.length;j++){
              if(s[j].parent == s[i].code){
                  a++;  
                  ind++;
              }
          }
          if(a == 0&&s[i].parent!=''){ 
              for(let n in s){
                  s[n].children = s[n].children?s[n].children:[];
                  if(s[n].code == s[i].parent){
                      s[n].children.push(s[i]);
                  }
              }
              s.splice(i,1);
              i--; 
          }
      }
      if(ind != 0){ 
          Tree(s);
      }
  }
  return s;
}
function handleTree(s){ 
  s = Tree(s);
  console.log(s);
  return s;
}

handleTree(tree)