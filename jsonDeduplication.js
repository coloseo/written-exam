function jsonDeduplication (jsonObj) {
  const map = new Map();
  // 重后往前删除
  for (let i = jsonObj.length-1; i >= 0; i--) {
    console.log(jsonObj[i].serial);
    if (!map.has(jsonObj[i].serial)) map.set(jsonObj[i].serial, jsonObj[i]);
    else {
      console.log('delete' + i)
      jsonObj.splice(i, 1);
    }
  }
  return jsonObj;
}

console.log(jsonDeduplication([{
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
}]));