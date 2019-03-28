
// 1. 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。

function reverse(str) {
	var myArray=str.split("");
  	var a = myArray.reverse();
 	var str1 = a.join("");
  	return str1;
}

var s = "WangYiBei!"

console.log(reverse(s));