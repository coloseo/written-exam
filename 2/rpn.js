// 适用于无符整数四则运算, 但运算结果可能是负数，如减法

(function () {
  'use strict'
  const rpn = {
    _precedence: {'/': 2, '*': 2, '-': 1, '+': 1, '#': 0},
    
    /**
     * operations
     * @private
     */
    _operation: {
      '+': (a, b) => (+a) + (+b),
      '-': (a, b) => (+a) - (+b),
      '*': (a, b) => (+a) * (+b),
      '/': (a, b) => (+a) / (+b)
    },

    /**
     * split expression to array
     * @private
     * @param exp - infix expression
     * @returns {Array|null}
     */
    _splitExp: function (exp) {
      return exp.match(/\d+|[^\d\s\t]/g);
    },

    /**
     * check a character, is or not an operator
     * @private
     * @param char - character
     * @return {boolean}
     */
    _isOperator: function (char) {
      return /^[\/\*\-\+#]$/.test(char);
    },

    /**
     * check character, is or not a bracket
     * @private
     * @param char - character
     * @retuens {boolean}
     */
    _isBracket: function (char) {
      return /^[\(\)]$/.test(char);
    },

    /**
     * check string, is or not a number
     * @private
     * @param str - character
     * @returns {boolean}
     */
    _isNumber: function (str) {
      return /^\d+$/.test(str);
    },

    /**
     * check exp, is or not a valid expression
     * @param {string} exp - expression 
     * @returns {boolean} - 
     */
    _isValidExpression: function (exp) { // 含有除数字、括号、操作符以外的符号即为非法
      return !/[^\d\s\t\+\-\*\/\(\)]/.test(exp);
    },

    /**
     * transfer infix expression to reverse polish notation
     * @param exp - infix express
     * @returns {string|null}
     */
    infix2rpn: function(exp) {
      if (!rpn._isValidExpression(exp)) return null;  // 用于保证以下处理的是合法的表达式

      var arrExp = rpn._splitExp(exp);  // 输入串分割
      var opStack = [];                 // 运算符栈
      var rpnStack = [];                // 存放逆波兰式结果
      
      arrExp = arrExp.concat('#');      // 加入最低优先级的算符 '#'
      
      var i,                        // 用于遍历arrExp
          item,                     // 遍历arrExp时暂存
          op,                       // 暂存opStack中的操作符
          len = arrExp.length;      // 记录arrExp长度
      for (i = 0; i < len; i ++) {
        item = arrExp[i];
        if (rpn._isNumber(item)) {
          rpnStack.push(item);
        } else if (rpn._isOperator(item)) {  
          while (opStack.length) {
            op = opStack[opStack.length-1];        // push性能低于pop和数组按索引取值，要尽量避免push
            if(op === '(') {                // 栈顶运算符是左括号,需单独处理
              break;
            } else if (rpn._precedence[item] > rpn._precedence[op]) { // 否则，栈顶是运算符。并且如果...
              // 当前算符优先级大于算符栈栈顶优先级
              break;
            } else {                    // 当前算符优先级小于等于算符栈栈顶优先级
              rpnStack.push(opStack.pop()); // 弹出算符栈栈顶算符并放入逆波兰式结果栈中
            }
          }
          opStack.push(item);           // 将运算符压入
        } else {                        // item是括号
          if (item === '(') {           // 是 '('
            opStack.push(item);
          } else  {  // 否则，item是 ')'
            while (opStack[opStack.length-1] !== '(') {
              rpnStack.push(opStack.pop());
            }                   // ')' 遇 '(' ，相抵消
            opStack.pop();
          }
        }
      } 
      return rpnStack.length ? rpnStack.join(' ') : null;
    },


    /**
     * calculate reverse polish notation - 本函数目前只支持二元运算
     * @param exp - reversed polish notation
     * @returns {number|null}
     */
    rpnCalculate: function (exp) {
      if (!rpn._isValidExpression(exp)) return null;  // 用于保证以下处理的是合法的表达式

      var arrExp = rpn._splitExp(exp);
      var calcStack = [];
      var item;                       // in arrExp
      var param1, param2;           // 运算对象

      var i, len = arrExp.length;
      for (i = 0; i < len; i ++) {
        item = arrExp[i];
        if (rpn._isNumber(item)) {
          calcStack.push(+item);    // 先将item转换为数值再压栈
        } else {                    // 否则item就是运算符
          param2 = calcStack.pop();
          param1 = calcStack.pop();
          calcStack.push(rpn._operation[item](param1, param2));// 执行运算并将结果压栈
        }
      }  
      return calcStack.pop();
    },

    /**
     * calculate expression
     * @param exp - expression string
     * @returns {number|null}
     */
    calculate: function (exp) {
      return rpn.rpnCalculate(rpn.infix2rpn(exp));
    }
  }
  if (typeof module !== 'undefined' && module.exports) {
    module.exports = rpn;
  }

  if (typeof window !== 'undefined') {
    window.rpn = rpn;
  }
}());
