// 逆波兰
function calc(expr) {
    // TODO: Your awesome code here
    if (!expr) return 0;  //字符串为空，返回0
    
    var arr = expr.split(' ')
    var elems = []
    
    var item;
    
    while (item = arr.shift()) { 
      if (!isNaN(+item)) {  
        elems.push(+item)
      } else {
        var res = count(item, elems.pop(), elems.pop())
        elems.push(res)
        console.log(elems)
      }
    }
    
    //  运算符计算
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
    console.log(elems)
    return elems.pop()
    
  }
