//第一题
let result = "";

function start() {
    let str = "hello";
    document.write("题一:<br/>", reverse(str));
}

function reverse(s) {
    let sub1;
    if (s.length === 1) {
        result += s;
    } else {
        sub1 = s.substr(0, s.length - 1);
        result += s.substring(s.length - 1);
        reverse(sub1);
    }
    return result;
}

//第二题
function start() {
    let str = "2 3 4 + -";
    document.write("题二:<br/>", expr(str));
}

function expr(str) {
    str = str.replace(/\s+/g, "");
    let ary = str.split('');
    console.log(ary);
    let item;
    let ele = [];
    //判断str是否为空
    if (!str) {
        return 0;
    }
    while (item = ary.shift()) {
        if (!isNaN(item)) {
            ele.push(item);
        } else {
            ele.push(count(item, parseInt(ele.pop()), parseInt(ele.pop())))
        }
    }
    return ele;
}

function count(item, num1, num2) {
    let result = 0;
    switch (item) {
        case '-':
            result = num1 - num2;
            break;
        case'+':
            result = num1 + num2;
            break;
        case '*':
            result = num1 * num2;
            break;
        case '/':
            result = num1 / num2;
            break;
        default:
            break;
    }
    return result;
}

//第三题
function splitAry() {
    let ary = [3, 1, 4, 1, 5, 9, 2, 6];
    document.write("题三:<br/>", sort(ary));
}

function sort(ary) {
    if (ary.length === 1) {
        return ary;
    }
    let mid = ary.length / 2;
    //分割
    let left = ary.slice(0, mid);
    let right = ary.slice(mid);
    return merge(sort(left), sort(right));
}

function merge(args1, args2) {
    let temp = [];
    while (args1.length > 0 && args2.length > 0) {
        if (args1[0] < args2[0]) {
            temp.push(args1.shift())
        } else {
            temp.push(args2.shift())
        }
    }
    return temp.concat(args1, args2);
}

//第四题
function json() {
    let data = [{
        "name": "张三",
        "serial": "0001"
    },
        {
            "name":
                "李四",
            "serial":
                "0002"
        }
        ,
        {
            "name":
                "王五",
            "serial":
                "0003"
        }
        ,
        {
            "name":
                "王五2",
            "serial":
                "0003"
        }
        ,
        {
            "name":
                "赵四",
            "serial":
                "0004"
        }
        ,
        {
            "name":
                "小明",
            "serial":
                "005"
        },
        {
            "name":
                "小张",
            "serial":
                "006"
        },
        {
            "name":
                "小李",
            "serial":
                "006"
        },
        {
            "name":
                "小李2",
            "serial":
                "006"
        },
        {
            "name":
                "赵四2",
            "serial":
                "0004"
        }
    ];
    let ary = [];
    let flag = false;
    for (let i = 0; i < data.length; i++) {
        if (i === 0) {
            ary.push(data[i]);
        }
        for (let j = 0; j < ary.length; j++) {
            if (ary[j].serial === data[i].serial) {
                flag = false;
            } else {
                flag = true;
            }
        }
        if (flag) {
            ary.push(data[i]);
        }
    }
    document.write("题四:<br/>" + JSON.stringify(ary))
}

//第五题
function json() {
    let data = [
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
    tree(data, "code");
}

function tree(data, code) {
    //存储结果
    let result = {};
    //将parent作为键名,存储数据
    let tree = {};
    for (let t in data) {
        tree[data[t][code]] = data[t];
    }
    console.info(tree);
    for (let p in tree) {
        //判断父节点是否存在
        if ((tree[p].parent)) {
            //判断节点是否存在
            if (!tree[tree[p].parent].list) {
                tree[tree[p].parent].list = new Object();
            }
            tree[tree[p].parent].list[tree[p].code] = tree[p];
        } else {
            result[tree[p].code] = tree[p];
        }
    }
    document.write("题五:<br/>",
        JSON.stringify(result)
    )
}