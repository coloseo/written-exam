unique = () => {
    
    let arr = [{
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

    let newArr = [];
    for (let item of arr) {
        const { serial = '' } = item;
        const aaa = newArr.find(item => item.serial === serial);
        if (!aaa) {
            newArr.push(item);
        }
    }
    return newArr;

}
