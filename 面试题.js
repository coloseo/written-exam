//1.编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
reverse = s => s.length > 0 ? reverse(s.substr(1)) + s.charAt(0) : s
console.log(reverse("xueming"))
//2.编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *
expr = s => {
    s = s.split('')
    let res = []
    for (let item of s) {
        if (oper(item)) {
            //如果是符号就做运算操作
            switch (item) {
                case '+':
                    res.push(res.pop() + res.pop())
                    break;
                case '*':
                    res.push(res.pop() * res.pop())
                    break;
                case '-': {
                    //减法跟除法是相反的
                    let right = res.pop()
                    res.push(res.pop() - right)
                    break;
                }
                case '/': {
                    let right = res.pop()
                    res.push(res.pop() / right)
                    break;
                }
                default:
                    res.push(parseInt(item))
                    break;
            }
        } else {
            //如果不是符号的话就入栈
            res.push(parseInt(item))
        }
    }
    //出栈 最后一个就是最终结果
    return res.pop()

}
//判断是否为符号
oper = val => '+-*/'.indexOf(val) >= 0
console.log(expr('254-/'))
//3.归并排序将3，1，4，1，5，9，2，6 排序

merge = (array, L, M, R) => {
    let left = []
    let right = []
    //给左边的list 赋值
    for (let i = L; i < M; i++) {
        left[i - L] = array[i]
    }
    //给右边的list 赋值
    for (let i = M; i <= R; i++) {
        right[i - M] = array[i]
    }
    let i = 0;
    let j = 0;
    let k = L;
    while (i < left.length && j < right.length) {
        //那边小就放那边
        // k++ 把数组的下标移动
        //i++ 左边数组的下标移动
        //j++右边下标移动
        if (left[i] < right[j]) {
            array[k++] = left[i++]
        } else {
            array[k++] = right[j++]
        }

    }
    while (i < left.length) {
        //左边没有到顶就把剩余的数字放进去
        array[k++] = left[i++]
    }
    while (i < right.length) {
        //右边没有到顶就把剩余的数字放进去
        array[k++] = right[j++]
    }
}
mergeSort = (array, L, R) => {
    if (L == R) {
        return;
    } else {
        let M = parseInt((L + R) / 2);
        mergeSort(array, L, M);//切左边
        mergeSort(array, M + 1, R);//切右边
        merge(array, L, M + 1, R);
    }
}


let array = [3,1,4,1,5,9,2,6]
mergeSort(array, 0, array.length-1)
console.log(array)


//4.对下面的 json 字符串 serial 相同的进行去重。
let json = [
    {
        "name": "张三",
        "serial": "0001"
    },
    {
        "name": "李四",
        "serial": "0002"
    },
    {
        "name": "王五",
        "serial": "0003"
    },
    {
        "name": "王五2",
        "serial": "0003"
    },
    {
        "name": "赵四",
        "serial": "0004"
    },
    {
        "name": "小明",
        "serial": "005"
    },
    {
        "name": "小张",
        "serial": "006"
    },
    {
        "name": "小李",
        "serial": "006"
    },
    {
        "name": "小李2",
        "serial": "006"
    },
    {
        "name": "赵四2",
        "serial": "0004"
    }];
let obj = []
//使用reduce
person = json.reduce((prev, next) => {
    //obj[next.serial] = true 存在就在设置成true
    obj[next.serial] ? "" : obj[next.serial] = true && prev.push(next)
    return prev
}, [])
//5.把下面给出的扁平化json数据用递归的方式改写成组织树的形式
let place = [
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
place = place.filter(father => {
    //每次都会寻找符合father.code的数据
    let childNode = place.filter(child => child.parent == father.code);
    childNode.length > 0 ? father.children = childNode : "";
    return father.parent == "";
})
