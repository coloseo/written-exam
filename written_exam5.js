/**
 * Author: 张芸海
 */

// 把written_exam5_json.json给出的扁平化json数据用递归的方式改写成组织树的形式
const data = require('./written_exam5_json.json')

let mapIndex = new Map();
let newData = [];
while (data.length) {
    let index = []
    let node = mapNode(data[0])
    if (mapIndex.has(node.parent)) {
        index = [...mapIndex.get(node.parent)];
        let parentNode = getValueByIndex(newData, [...index]);
        parentNode.children.push(node);
        index.push(parentNode.children.length - 1)
        mapIndex.set(node.code, index)
        data.shift();
    } else {
        if (node.code.length > 3) {
            let fistNode = data.shift();
            data.push(fistNode);
        }
        newData.push(node);
        index.push(newData.length - 1)
        mapIndex.set(node.code, index);
        data.shift()
    }
}
function mapNode({ id, name, code, parent }) {
    return {
        id: id,
        name: name,
        code: code,
        parent: parent,
        children: []
    }
}
function getValueByIndex(data, index) {
    if (index.length === 0) {
        return data;
    }
    let selfIndex = index[0];
    index.shift();
    if(data.children){
        return getValueByIndex(data.children[selfIndex], index);  
    }else{
        return getValueByIndex(data[selfIndex], index);
    }
}
console.log(newData)