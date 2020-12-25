function sort(arr) {
    if (arr.length <= 1) return arr
    var num = Math.floor(arr.length / 2)
    var numValue = arr.splice(num, 1)
    var left = []
    var right = []
    left = arr.filter(item => item < numValue)
    right = arr.filter(item => item >= numValue)
    return sort(left).concat(numValue, sort(right))
} 
let newarr = sort([3,1,4,1,5,9,2,6 ])
console.log(newarr)