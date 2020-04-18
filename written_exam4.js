/**
 * Author: 张芸海
 */

// 对written_exam4_json.json的 json 字符串 serial 相同的进行去重。
const data = require('./written_exam4_json.json')

let isMap = new Map();
for(let i = 0; i< data.length;){
    if(isMap.has(data[i].serial)){
        data.splice(i,1)
    }else{
        isMap.set(data[i].serial,data[i])
        i++;
    }
}
console.log(data)
