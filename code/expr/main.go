package main

import (
	"fmt"
	"os"
	"strconv"
)

//编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *
func main(){
	args:=os.Args
	if len(args)<2{
		fmt.Println("请通过命令行运行程序，各平台请选择对应版本，且应该带上参数")
	}else{
		fmt.Println("读取到参数：",args[1:])
		fmt.Println("计算结果：",expr(args[1:]))
	}
}
func expr(args []string) int {
	var stack []int
	pop := func() int {
		r := stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		return r
	}
	push := func(v int) {
		stack = append(stack, v)
	}

	for _, arg := range args {
		var op func(a, b int) int
		switch arg {
		case "+":
			op = func(a, b int) int {
				return a+b
			}
		case "-":
			op = func(a, b int) int {
				return a-b
			}
		case "*":
			op = func(a, b int) int {
				return a*b
			}
		case "/":
			op = func(a, b int) int {
				return a/b
			}
		default:
			v, err := strconv.Atoi(arg)
			if err != nil {
				panic(err)
			}
			push(v)
			continue
		}
		b := pop()
		a := pop()
		push(op(a, b))
	}
	return pop()
}
