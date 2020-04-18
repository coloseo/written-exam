/**
 * Author: 张芸海
 */

// 用归并排序将3，1，4，1，5，9，2，6 排序。
function sort(arr) {
    let length = arr.length;
    if (length < 2) return arr;
    let middle = Math.floor(length / 2);
    let leftArr = arr.slice(0, middle);
    let rightArr = arr.slice(middle);
    return merge(sort(leftArr), sort(rightArr));
}
function merge(left, right) {
    let result = [];
    let leftLength = left.length;
    let rightLength = right.length;
    while (leftLength && rightLength) {
        if (left[0] <= right[0]) {
            result.push(left.shift());
            --leftLength;
        } else {
            result.push(right.shift());
            --rightLength;
        }
    }
    while (leftLength){
        result.push(left.shift());
        --leftLength;
    }
    while (rightLength){
        result.push(right.shift());
        --rightLength;
    }
    return result;
}

console.log(sort([3,1,4,1,5,9,2,6]));