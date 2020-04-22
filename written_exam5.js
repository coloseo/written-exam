/**
 * Author: 张芸海
 */

// 把written_exam5_json.json给出的扁平化json数据用递归的方式改写成组织树的形式
const data = require('./written_exam5_json.json')

let mapIndex = new Map();
let newData = [];
let unsearchableLen = {
    total: 0,
    poerated:0,
};
while (data.length) {
    let index = []
    let node = mapNode(data[0])
    if (mapIndex.has(node.parent)) {
        if(node.hasOwnProperty('unsearchable')){
            unsearchableLen.total--;
            unsearchableLen.poerated = 0;
            if(!delete node.unsearchable){
                throw new Error('node\'s configurable is set to false, please check')
            }
        }
        index = [...mapIndex.get(node.parent)];
        let parentNode = getValueByIndex(newData, [...index]);
        parentNode.children.push(node);
        index.push(parentNode.children.length - 1)
        mapIndex.set(node.code, index)
        data.shift();
    } else {
        if (node.code.length !== 3) {
            data = isUnsearchable(data);
        }
        newData.push(node);
        index.push(newData.length - 1)
        mapIndex.set(node.code, index);
        data.shift()
    }
}
function isUnsearchable(Arr){
    if(unsearchableLen.total === unsearchableLen.poerated){
        throw new Error(`code of this ${Arr} cannot be found`)
    }
    let newArr = [...Arr];
    let fistNode = newArr.shift();
    if(fistNode.hasOwnProperty('unsearchable')){
        unsearchableLen.poerated++;
    }else{
        fistNode.unsearchable = true;
        unsearchableLen.total++;
    }
    newArr.push(fistNode);
    return newArr;
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