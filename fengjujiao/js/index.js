//4. 对下面的 json 字符串 serial 相同的进行去重。
let datas = [{
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
// 调用去重函数
filter(datas);

// 5.把下面给出的扁平化json数据用递归的方式改写成组织树的形式
let areas = [
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
// 
let tree = getTree(areas);
console.log(tree);