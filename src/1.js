// 1.编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
let str = "123456";
let result = reverse(str);
console.log(result);

function reverse(s) {
  let arr = s.split("");
  changeStr(arr, arr.length);
  return arr.join("");
}

function changeStr(arr, len) {
  if (len > 1) {
    for (let i = 0; i < len - 1; i++) {
      let temp = arr[i];
      arr[i] = arr[i + 1];
      arr[i + 1] = temp;
    }
    len -= 1;
    changeStr(arr, len);
  }
  return arr
}