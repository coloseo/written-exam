
// 2. 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *

function expr(val) {
    if (!val) return 0;

    var arr = val.split(' ')
    var elems = []

    var item;

    while (item = arr.shift()) {
      if (!isNaN(+item)) {
        elems.push(+item)
      } else {
        var res = count(item, elems.pop(), elems.pop())
        elems.push(res)
      }
    }

    function count (opera, num1, num2) {
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

    return elems.pop()

  }

  console.log(expr('2 3 4 + *'))
