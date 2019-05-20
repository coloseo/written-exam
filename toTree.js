// 输入：节点集、父节点
// 输出：树状结构图
// 方法：遍历数组找到第一层节点添加结果集，对第一层节点的集合递归，添加child属性，递归到最下层
function toTree (nodeArr, parent) {
  let res = [];
  for (let i = 0; i < nodeArr.length; i++) {
    if (nodeArr[i].parent === parent) {
      nodeArr[i].child = toTree(nodeArr, nodeArr[i].code);
      res.push(nodeArr[i]);
    }
  }
  return res;
}

// 输出只能打开第一层，可以通过chrome console查看完整输出
// 输入(arr，'') 将空字符串设置为初始父节点
console.log(toTree([
  {
    "id": "1",
    "name": "中国",
    "code": "110",
    "parent": ""
  },
  {
    "id": "2",
    "name": "北京市",
    "code": "110000",
    "parent": "110"
  },
  {
    "id": "3",
    "name": "河北省",
    "code": "130000",
    "parent": "110"
  },
  {
    "id": "4",
    "name": "四川省",
    "code": "510000",
    "parent": "110"
  },
  {
    "id": "5",
    "name": "石家庄市",
    "code": "130001",
    "parent": "130000"
  },
  {
    "id": "6",
    "name": "唐山市",
    "code": "130002",
    "parent": "130000"
  },
  {
    "id": "7",
    "name": "邢台市",
    "code": "130003",
    "parent": "130000"
  },
  {
    "id": "8",
    "name": "成都市",
    "code": "510001",
    "parent": "510000"
  },
  {
    "id": "9",
    "name": "简阳市",
    "code": "510002",
    "parent": "510000"
  },
  {
    "id": "10",
    "name": "武侯区",
    "code": "51000101",
    "parent": "510001"
  },
  {
    "id": "11",
    "name": "金牛区",
    "code": "51000102",
    "parent": "510001"
  }
], ''));

