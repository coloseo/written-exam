import sys

def expr(tokens):
    '''
    cmd:python expr.py 2 3 + -..
    return num
    '''

    stack = []
    for i in tokens:
        if i in ['+','-','*','/']:
            n1 = stack.pop()
            n2 = stack.pop()
            val = cal(n2,n1,i)
            stack.append(val)
        else:
            stack.append(int(i))
    return stack[0]
	

def cal(n1,n2,op):
    if op=='+':
        return n1+n2
    elif op == '-':
        return n1-n2
    elif op == '*':
        return n1*n2
    else:
        return n1//n2


if __name__ == "__main__":
    args = sys.argv
    result = expr(args[1:])
	