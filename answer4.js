// 4. 对下面的 json 字符串 serial 相同的进行去重。

function filter(Array){
        for (var i = 0; i < Array.length; i++) {
            for (var j =i+1; j <Array.length; ) {
                if (Array[i].serial == Array[j].serial ) {
                   Array.splice(j, 1);
                }else {
                   j++;
                }
            }
       }
       return Array;
    }

var arre = [{
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

filter(arre);
