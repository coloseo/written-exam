let arr = [{
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
    }
]

function unique(arr) {
    for (let i = 0; i < arr.length - 1; i++) {
        let old = arr[i]
        for (let j = i + 1; j < arr.length; j++) {
            if (old.name === arr[i].name && old.serial === arr[j].serial) {
                arr.splice(j, 1)
                j -= 1
            }
        }
    }
    return arr
}

let newArr = unique(arr)
console.log(newArr)