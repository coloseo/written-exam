package main

import (
	"encoding/json"
	"fmt"
	"strconv"
	"strings"
)

//1.编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
func reverse(v string) string {
	r := ""
	l := len(v)
	r += string(v[l-1])
	if l == 1 {
		return r
	} else {
		return r + reverse(v[0:l-1])
	}
}

//2.编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *
type Stack struct {
	v   []float64
	len int
}

func (s *Stack) push(f float64) {
	s.v = append(s.v, f)
	s.len = len(s.v)
}

func (s *Stack) pop() float64 {
	r := s.v[s.len-1]
	s.v = s.v[:s.len-1]
	s.len = len(s.v)
	return r
}

func expr(v string) string {
	var s Stack
	var calculation = func(str string) {
		v1 := s.pop()
		v2 := s.pop()

		switch str {
		case "+":
			s.push(v1 + v2)
		case "-":
			s.push(v1 - v2)
		case "*":
			s.push(v1 * v2)
		case "/":
			s.push(v2 / v1)
		}
	}

	str := strings.Split(v, " ")

	for _, v := range str {
		if index := strings.Index("+-*/", v); index < 0 {
			ts, _ := strconv.ParseFloat(v, 64)
			s.push(ts)
		} else {
			calculation(v)
		}
	}

	return fmt.Sprintf("%.2f", s.pop())
}

//3.用归并排序将3，1，4，1，5，9，2，6 排序。
func mergeSort(v []int) []int {
	var (
		ms func(v []int) []int
		m  func(l, r []int) []int
	)

	ms = func(v []int) []int {
		le := len(v)
		if le <= 1 {
			return v
		}
		n := le / 2
		l := ms(v[:n])
		r := ms(v[n:])
		return m(l, r)
	}
	m = func(l, r []int) []int {
		var rv []int
		li, ri := 0, 0
		for li < len(l) && ri < len(r) {
			if l[li] < r[ri] {
				rv = append(rv, l[li])
				li++
			} else {
				rv = append(rv, r[ri])
				ri++
			}
		}
		rv = append(rv, l[li:]...)
		rv = append(rv, r[ri:]...)
		return rv
	}

	return ms(v)
}

//4.对下面的 json 字符串 serial 相同的进行去重。
func duplicateRemoval(v string) string {
	type t struct {
		Name   string `json:"name"`
		Serial string `json:"serial"`
	}

	var s, r []t

	json.Unmarshal([]byte(v), &s)

	for i := range s {
		f := true
		for j := range r {
			if s[i].Serial == r[j].Serial {
				f = false
				break
			}

		}
		if f {
			r = append(r, s[i])
		}
	}

	str, _ := json.Marshal(r)

	return string(str)
}

//5.把下面给出的扁平化json数据用递归的方式改写成组织树的形式
func tissueTree(v string) string {
	type t struct {
		Id       string `json:"id"`
		Name     string `json:"name"`
		Code     string `json:"code"`
		Parent   string `json:"parent"`
		Children []t
	}

	var (
		s       []t
		roots   []t
		getTree func(root t) t
	)

	json.Unmarshal([]byte(v), &s)

	for i := 0; i < len(s); i++ {
		if s[i].Parent == "" {
			roots = append(roots, s[i])
			s = append(s[:i], s[i+1:]...)
			i--
		}
	}

	getTree = func(root t) t {
		for i := 0; i < len(s); i++ {
			if root.Code == s[i].Parent {
				root.Children = append(root.Children, getTree(s[i]))
			}
		}

		return root
	}

	for i, v := range roots {
		roots[i] = getTree(v)
	}

	str, _ := json.Marshal(roots)

	return string(str)
}

func main() {
	fmt.Println("1:", reverse("abcdefg"))
	fmt.Println("2:", expr("3 9.1 + 2.4 2 + 7 * 4 / -")) //3+9.1-(2.4+2)*7/4=-4.4
	fmt.Println("3:", mergeSort([]int{3, 1, 4, 1, 5, 9, 2, 6}))
	fmt.Println("4:", duplicateRemoval(`
		[{"name": "张三","serial": "0001"}, 
		{"name": "李四","serial": "0002"}, 
		{"name": "王五","serial": "0003"}, 
		{"name": "王五2","serial": "0003"}, 
		{"name": "赵四","serial": "0004"}, 
		{"name": "小明","serial": "005"}, 
		{"name": "小张","serial": "006"}, 
		{"name": "小李","serial": "006"}, 
		{"name": "小李2","serial": "006"}, 
		{"name": "赵四2","serial": "0004"}]
		`))
	fmt.Println("5:", tissueTree(`
		[{"id": "1","name": "中国","code": "110","parent": ""},
		{"id": "2","name": "北京市","code": "110000","parent": "110"},
		{"id": "3","name": "河北省","code": "130000","parent": "110"},
		{"id": "4","name": "四川省","code": "510000","parent": "110"},
		{"id": "5","name": "石家庄市","code": "130001","parent": "130000"},
		{"id": "6","name": "唐山市","code": "130002","parent": "130000"},
		{"id": "7","name": "邢台市","code": "130003","parent": "130000"},
		{"id": "8","name": "成都市","code": "510001","parent": "510000"},
		{"id": "9","name": "简阳市","code": "510002","parent": "510000"},
		{"id": "10","name": "武侯区","code": "51000101","parent": "510001"},
		{"id": "11","name": "金牛区","code": "51000102","parent": "510001"}]
		`))
}
