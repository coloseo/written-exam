function strReverse (str, newStr) {
  if (str === null || str.length <= 0) return newStr
  newStr += str[str.length-1]
  str = str.slice(0, -1)
  return strReverse(str, newStr)
}

// console.log(strReverse('qwertyuiop', ''));