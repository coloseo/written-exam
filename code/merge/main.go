package main

import (
	"fmt"
)

type WrittenExam interface {
	MergeSort()
}

type Merge struct {
}
//用归并排序将3，1，4，1，5，9，2，6排序。
func main(){
	var exam WrittenExam
	exam =&Merge{}
	exam.MergeSort()
}

func (c *Merge) MergeSort() {
	array:=[]int{3,1,4,1,5,9,2,6}
	fmt.Println("初始数组：",array)
	result:=mergeSort(array)
	fmt.Println("归并排序：",result)
}

func mergeSort(array []int)([]int) {
	length := len(array)
	gap := 1
	for gap < length {
		for i := 0; i < length; i += 2 * gap {
			mergeTwoValues(array, i, gap)
		}
		gap = gap * 2
	}
	return array
}
func mergeTwoValues(values []int, start int, gap int) {

	length := len(values)
	if start+gap >= length {
		return
	}
	slice := make([]int, 2*gap)
	lpos, rpos, slicepos := start, start+gap, 0
	for lpos < start+gap && (rpos < start+2*gap && rpos < length) {
		if values[lpos] <= values[rpos] {
			slice[slicepos] = values[lpos]
			lpos++
		} else {
			slice[slicepos] = values[rpos]
			rpos++
		}
		slicepos++
	}
	if lpos != start+gap {
		for lpos < start+gap {
			slice[slicepos] = values[lpos]
			lpos++
			slicepos++
		}
	} else if rpos != start+2*gap && rpos != length {
		for rpos < start+2*gap && rpos < length {
			slice[slicepos] = values[rpos]
			rpos++
			slicepos++
		}
	}
	for i := 0; i < slicepos; i++ {
		values[i+start] = slice[i]
	}
}