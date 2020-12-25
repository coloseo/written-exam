let json=[{
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

function deWeight(a, f) {
    let n = [],
        e = [];
    for (let i = 0; i < a.length; i++) {
        if (n.indexOf(a[i][f]) === -1) {
            n.push(a[i][f]);
            e.push(a[i]);
        }
    }
 
    return e;
 }


 let newJson = deWeight(json, 'serial');
console.log(newJson);