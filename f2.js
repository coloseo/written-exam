const readline = require('readline')
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})
rl.on('line', function (line) {
    let arr = line.split(' ')
    console.log(expr(arr))
})

function expr(arr) {
    let stack = [];
    for (let i = 0; i < arr.length; i++) {
        if (!isOperation(arr[i])) {
            stack.push(parseFloat(arr[i]))
        } else {
            let num1 = stack.pop()
            let num2 = stack.pop()
            console.log(num1, num2)
            switch (arr[i]) {
                case '*':
                    stack.push(num1 * num2)
                    break;
                case '/':
                    stack.push(num1 / num2)
                    break;
                case '+':
                    stack.push(num1 + num2)
                    break;
                case '-':
                    stack.push(num1 - num2)
                    break;
            }
        }
    }
    return stack[0]
}

function isOperation(s) {
    return ['+', '-', '*', '/'].includes(s)
}