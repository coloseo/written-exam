### 1.
```js
let reverse = s => {
    let i = 1
    if(arguements[1] === s.length) return s
    i++
    let arr = s.splite('')
    let char = arr.shift()
    arr.push(char)
    s = arr.join('')
    reverse(s, i)  
}

reverse('123456')
```

### 2.
``` js
let expr = () => {
    let arr = arguements.map(item => item)
    let res = 0
    while((typeof arr[arr.length-1]) != 'Number') {
        let temp = 0
        for(let i = 0; i < arr.length; i++) {
            switch(arr[i]) {
                case '+': temp = arr[i-2] + arr[i-1]; arr.splice(i-2, 3, temp); break;
                case '-': temp = arr[i-2] - arr[i-1]; arr.splice(i-2, 3, temp); break;
                case '*': temp = arr[i-2] * arr[i-1]; arr.splice(i-2, 3, temp); break;
                case '/': temp = arr[i-2] / arr[i-1]; arr.splice(i-2, 3, temp); break;
                default: return
            }
        }
    }
}


expr(1,2,3,'+','*')
```

### 3.


### 4.
``` js
let data = [{
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

  let func = data => {
      for(let i = 0; i < data.length; i++) {
          for(let j = i+1; j < data.length; j++) {
              if(data[i].serial == data[j].serial) data.splice(j,1)
          }
      }
  }

  func(data)
```

### 5.
``` js
let data = [
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

  let func = data => {
      if(data.length === 1) return data
      for(let i = 1; i < data.length; i++) {
          if(data[i].parent === data[0].code) {
              let temp = data.splice(i, 1)
              data[0].children = temp
          }
      }
      func(data.children)
  }


  func(data)

```