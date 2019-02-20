let students = [{
    name: '张三',
    serial: '0001'
  }, {
    name: '李四',
    serial: '0002'
  }, {
    name: '王五',
    serial: '0003'
  }, {
    name: '王五2',
    serial: '0003'
  }, {
    name: '赵四',
    serial: '0004'
  }, {
    name: '小明',
    serial: '005'
  }, {
    name: '小张',
    serial: '006'
  }, {
    name: '小李',
    serial: '006'
  }, {
    name: '小李2',
    serial: '006'
  }, {
    name: '赵四2',
    serial: '0004'
}];

function ArrayFilter(data){
    let _arr = [];
    let _index = [];

    for(let i = 0,ih = data.length;i<ih;i++){
        let _this = data[i];
        let _serial = _this.serial;
        if(_arr.indexOf(_serial) === -1){
            _arr.push(_serial);
        }else{
            _index.push(_this);
        }
    }

    for(let z =0,zh=_index.length;z<zh;z++){
        let _item = _index[z];
        let _i = data.indexOf(_item);
        data.splice(_i,1);
    }

    console.log(data);
    return data;
}

ArrayFilter(students);