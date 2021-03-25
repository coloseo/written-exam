function sort(arr){
    if(arr.length <= 1){
        return arr
    }
    let p = Math.floor(arr.length / 2)
    let arr1 = arr.slice(0, p)
    let arr2 = arr.slice(p)
    return merge(sort(arr1), sort(arr2))
}

function merge(arr1, arr2){
    let result = [];
    while(arr1.length > 0 && arr2.length > 0){
        if(arr1[0] <= arr2[0]){
            result.push(arr1.shift())
        }else{
            result.push(arr2.shift())
        }
    }
    while(arr1.length){
        result.push(arr1.shift())
    }

    while(arr2.length){
        result.push(arr2.shift())
    }
    
    return result
}

console.log(sort([3,1,4,1,5,9,2,6]))