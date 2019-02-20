const areas = [
    {
      id: 1,
      name: '中国',
      code: '110',
      parent: '',
    },
    {
      id: 2,
      name: '北京市',
      code: '110000',
      parent: '110',
    },
    {
      id: 3,
      name: '河北省',
      code: '130000',
      parent: '110',
    },
    {
      id: 4,
      name: '四川省',
      code: '510000',
      parent: '110',
    },
    {
      id: 5,
      name: '石家庄市',
      code: '130001',
      parent: '130000',
    },
    {
      id: 6,
      name: '唐山市',
      code: '130002',
      parent: '130000',
    },
    {
      id: 7,
      name: '邢台市',
      code: '130003',
      parent: '130000',
    },
    {
      id: 8,
      name: '成都市',
      code: '510001',
      parent: '510000',
    },
    {
      id: 9,
      name: '简阳市',
      code: '510002',
      parent: '510000',
    },
    {
      id: 10,
      name: '武侯区',
      code: '51000101',
      parent: '510001',
    },
    {
      id: 11,
      name: '金牛区',
      code: '51000102',
      parent: '510001',
    },
];

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

let tree = getTree(areas);
console.log(tree);