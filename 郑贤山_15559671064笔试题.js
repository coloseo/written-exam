// 第一题
function reverse(s1) {
    if (s1.length = 1)
        return s1

    var a = s1[0]
    var ax = s1.substring(1)
    return reverse(ax) + a
}

// 第二题
function f(ss, fh) {
    var s = ss.pop()
    while (ss.length != 0)
        s = eval(s + fh.pop + ss.pop)
    return s

}
var s2 = '2,3,4,+,*'
var arr = s2.split(',')
var n = Math.floor((arr.length - 1) / 2) + 1
var x = f(arr.slice(0, n).reverse, arr.slice(n).reverse)

// 第三题
var a3 = [3, 1, 4, 1, 5, 9, 2, 6]
function sort(a3) {
    if (a3.length == 1)
        return a3
    var min = a3[0]
    var iii = 0
    for (let i = 0; i < a3.length; i++) {
        var cur = a3[i]
        cur < min ? iii = i : null
    }
    a3.splice(iii, 1)
    return min + sort(a3)
}


// 第四题
var data4 = [{
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
var a4 = {}
var arr = []
data4.forEach(x => a[x.serial] == null ? a[x.serial] = x : null)
for (var x in a) arr.push(a[x])
console.log(arr)


var data5 = [
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


// 第五题
function f(t, parent) {
    if (t.length == 0)
        return t
    for (var obj of t) {
        if (obj.code == parent) {
            obj.c = obj.c || []
            return obj.c
        }
        if (obj.c == null)
            continue
        var r = f(obj.c, parent)
        if (r == null)
            continue
        return r
    }
}

var obj = []
data5.forEach(x => f(obj, x.parent).push(x))
console.log(JSON.stringify(obj))