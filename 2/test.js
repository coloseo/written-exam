
const textInput = document.getElementById("text-input");
const submitExpression = document.getElementById("submit-expression");
const submitRpn = document.getElementById("submit-rpn");
const rpnResult = document.getElementById("rpn");
const rpnCalcResult = document.getElementById("result");

submitExpression.addEventListener('click', function (event) {
    // 转换算术表达式为逆波兰表达式
    let temp = rpn.infix2rpn(textInput.value);
    rpnResult.textContent = temp;
    // 计算逆波兰表达式的值
    rpnCalcResult.textContent = rpn.rpnCalculate(temp);
});

submitRpn.addEventListener('click', function () {
    // 将逆波兰表达式格式化输出
    let temp = rpn._splitExp(textInput.value).join(' ');
    rpnResult.textContent = temp;
    // 计算逆波兰表达式的值
    rpnCalcResult.textContent = rpn.rpnCalculate(temp);
});
