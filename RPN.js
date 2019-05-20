function rpn (str) {
  // 只考虑加减乘除
  // 输入：后缀表达式
  // 输出：逆波兰计算结果
  const op = ['+', '-', '*', '/']
  const opMethod = {
    '+': function (op1, op2) {
      return parseInt(op1) + parseInt(op2);
    },
    '-': function (op1, op2) {
      return parseInt(op1) - parseInt(op2);
    },
    '*': function (op1, op2) {
      return parseInt(op1) * parseInt(op2);
    },
    '/': function (op1, op2) {
      return parseInt(op1) / parseInt(op2);
    }
  }
  let args = str.split(' ');
  console.log(args);
  if (args[0] === 'expr') args[0] = '#';
  else throw new Error('command error');
  let stack = [], len = args.length-1, index = 1;
  while (index <= len) {
    if (op.indexOf(args[index]) !== -1) {
      let op2 = stack.pop(),
          op1 = stack.pop();
      if (op1 && op2) {
        let res = opMethod[args[index]](op1, op2);
        stack.push(res);
        index++;
      } else throw new Error('expr error');
    } else {
      stack.push(args[index]);
      index++;
    }
  }
  return stack.pop(); 
}

console.log(rpn('expr 5 1 2 + 4 * + 3 -')) // 14
console.log(rpn('expr 2 3 4 + *')) // 14
console.log(rpn('expr 14 3 4 + /')) // 2
// console.log(rpn('2 3 4 + *'))  // command error
console.log(rpn('expr 7 8 + -'))  // exp error
