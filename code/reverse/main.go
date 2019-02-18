package main

import (
	"fmt"
)

type WrittenExam interface {
	RecursionReverse()
}

type Reverse struct {
}

//编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
func main(){
	var exam WrittenExam
	exam =&Reverse{}
	exam.RecursionReverse()
}

func(c *Reverse) RecursionReverse() {
	s:=""
	fmt.Println("请输入一个字符串，按回车结束。")
	fmt.Scanln(&s)
	fmt.Println("递归逆序后的字符串为:",reverse(s))
}

func reverse(s string)(result string) {
	if len(s)==0{
		return
	}
	return string((s)[len(s)-1])+reverse(s[:len(s)-1])
}