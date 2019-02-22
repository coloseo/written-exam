// 去重函数
function filter(datas) {
    let _arr = [];
    let _index = [];
    datas.forEach(function(data,index){
       
        let _this = data;
        let _serial = _this.serial;
        if(_arr.indexOf(_serial) === -1){
            _arr.push(_serial);
        }else{
            _index.push(_this);
        }
    })
    // 删除重复点
    _index .forEach(function(item,index){
        let _item=item;
        let _ind=datas.indexOf(_item);
        datas.splice(_ind,1)
    })
    console.log(datas)
}

// 组织树函数
function getTree(data){
    let obj = {};
    
    for(let i = 0,ih = data.length;i<ih;i++){
        let item = data[i];
        let parentId = item.parent;
        if(parentId === ""){
            let chinds = findChild(data, item.code);
            if(chinds.length){
                for(let y = 0,yh = chinds.length;y<yh;y++){
                    let _items = chinds[y];
                    let _childs = findChild(data, _items.code);
                    _childs.length && (_items.child = _childs);
                }
                item.child = chinds;
            }
            obj[item.code] = item;
        }
    }

    return obj;
    
}

function findChild(data, id){
    let child = [];
    for(let i = 0,ih = data.length;i<ih;i++){
        let item = data[i];
        let parentId = item.parent;
        if(parentId === id){
            child.push(item);
        }
    }
    return child;
}

