expr = (arr = []) => {

    if (!arr)
        return 0;

    var t = arr.split(' ')
    var e = [];
    let item = '';
    while (item = t.shift) {
        if (!isNaN(+item)) {
            e.push(+item)
        } else {
            var res = count(item, e.pop, e.pop)
            e.push(res)

        }
    }
}

count = (opera, num1, num2) => {

    switch (opera) {
        case '+':
            return num2 + num1
        case '-':
            return num2 - num1
        case '*':
            return num2 * num1
        case '/':
            return num2 / num1
    }

}
