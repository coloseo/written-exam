// 2.编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *

let evalRPN = function (tokens) {
    const stack = [];
    const map = new Map();
  
    map.set("*", (a, b) => a * b);
    map.set("-", (a, b) => a - b);
    map.set("+", (a, b) => a + b);
    map.set("/", (a, b) => ~~(a / b));
  
    tokens.forEach((token) => {
      if (map.has(token)) {
        const num1 = stack.pop();
        stack.push(map.get(token)(stack.pop(), num1));
      } else {
        stack.push(+token);
      }
    });
  
    return stack[0];
  };