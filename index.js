const s = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';

/**
 * 第一题
 * @param {String} str 
 * @returns {String}
 */
function reverse(str) {
    if (str.length === 0) {
        return ''
    }
    return str.substr(str.length - 1, 1) + reverse(str.substr(0, str.length - 1))
}


let arr = [3, 1, 4, 1, 5, 9, 2, 6];
/**
 * 第三题
 * @param {Array} arr 需要排序的数组
 * @param {Number} first 其实下标
 * @param {Number} mid 分界下标
 * @param {Number} last 结束下标
 * @param {Array} temp 临时数据
 * @returns 
 */
function mergeArray(arr, first, mid, last, temp) {
    let i = first;
    let m = mid;
    let j = mid + 1;
    let n = last;
    let k = 0;
    while (i <= m && j <= n) {
        if (arr[i] < arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
        }
    }
    // 其中有一个不满足条件以后，后序都把满足条件的写到temp
    while (i <= m) {
        temp[k++] = arr[i++];
    }
    while (j <= n) {
        temp[k++] = arr[j++];
    }
    // 对arr进行排序
    for (let l = 0; l < k; l++) {
        arr[first + l] = temp[l];
    }
    return arr;
}
// 递归实现归并排序
/**
 * 
 * @param {Array} arr 排序的原数组
 * @param {*} first 起始下标
 * @param {*} last 结束下标
 * @param {*} temp 临时数组
 * @returns 
 */
function mergeSort(arr, first, last, temp) {
    if (first < last) {
        let mid = Math.floor((first + last) / 2);
        mergeSort(arr, first, mid, temp);    // 左子数组有序
        mergeSort(arr, mid + 1, last, temp);   // 右子数组有序
        arr = mergeArray(arr, first, mid, last, temp);
    }
    return arr;
}


let jsonStrArr = [{
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

/**
 * 第四题去重
 * @param {Array} arr 
 */
function serial(arr) {
    let obj = {};
    for (let i = 0; i < arr.length; i++) {
        const element = arr[i];
        if (obj[element.serial]) {
            arr.splice(i, 1);
            i--;
            continue;
        } else {
            obj[element.serial] = 1;
        }
    }
    return arr;
}


let tree = [
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
];

/**
 * 第五题扁平化数组
 * @param {Array} arr 
 * @param {String} parent 
 * @returns 
 */
function treeHandle(arr, parent) {
    let temp = [];
    let list = [];
    for (let i = 0; i < arr.length; i++) {
        if (arr[i].parent == parent) {
            let obj = arr[i];
            temp = treeHandle(arr, obj.code);
            if (temp.length > 0) {
                obj.child = temp;
            }
            list.push(obj);
        }
    }
    return list;
}

// console.log(reverse(s));
// console.log(mergeSort(arr, 0, arr.length - 1, []))

// console.log(serial(jsonStrArr));
// console.dir(treeHandle(tree, ''));
let o = { a: 1, b: 2 }
for (const p of o) {
    console.log(p)
}

