let evalRPN = function(tokens) {
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