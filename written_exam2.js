/**
 * Author: 张芸海
 */

// 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *
const readLine = require('readline');
const rl = readLine.createInterface({
    input: process.stdin,
    output: process.stdout
});
console.info('请输入逆波兰表达式')
rl.on('line', (input) => {
    input = input.replace(/\s+/g, ' ').trim();
    let inputArray = input.split(' ');
    let inputExpression = inputArray.slice(1);
    let expression = [];
    if (inputArray[0] === 'expr' && inputExpression.length > 0) {
        let result = 0
        for (let i = 0; i < inputExpression.length; i++) {
            result = calculation(inputExpression[i], expression)
            if (!result) {
                return 0;
            }
            expression = result
        }
        if (expression.length > 1) {
            console.error('请正确输入表达式');
            return 0
        }
        console.log(`结果为${expression[0]}`)
        return 0;
    } else if (inputArray[0] === 'exit') {
        rl.close();
    } else {
        console.error('请正确输入命令或键入\'exit\'退出')
        return 0;
    }
}
)
function calculation(val, expression) {
    let isModel = isError(val, expression)
    if (isModel) {
        let { model, num } = isModel;
        if (model === 'number') {
            expression.push(num);
            return expression;
        }
        if (model === 'count') {
            let result = count(val, num.num1, num.num2);
            expression.splice(-2, 2, result);
            return expression;
        }
    }
    console.error('请正确输入表达式');
    return false;
}
function count(opera, num1, num2) {
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
function isError(val, expression) {
    let isNumber = (val) => !isNaN(val)
    if (isNumber(val)) {
        val = Number(val)
        return {
            model: 'number',
            num: val,
        }
    }
    if (val === '+' ||
        val === '-' ||
        val === '*' ||
        val === '/') {
        let length = expression.length;
        if (length < 2) {
            return false
        }
        let num1 = expression[length - 1];
        let num2 = expression[length - 2]
        if (!isNumber() && !isNumber(expression[length - 2])) {
            return false
        }
        return {
            model: 'count',
            num: {
                num1: num1,
                num2: num2,
            },
        }
    }
    return false
}