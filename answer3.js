// 3. 用归并排序将3，1，4，1，5，9，2，6 排序.

function mergeArray(arr, first, mid, last, temp) {
    let i = first;
    let m = mid;
    let j = mid+1;
    let n = last;
    let k = 0;
    while(i<=m && j<=n) {
      if(arr[i] < arr[j]) {
        temp[k++] = arr[i++];
      } else {
        temp[k++] = arr[j++];
      }
    }
    while(i<=m) {
      temp[k++] = arr[i++];
    }
    while(j<=n) {
      temp[k++] = arr[j++];
    } 
    for(let l=0; l<k; l++) {
      arr[first+l] = temp[l];
    }
    return arr;
  }

  function merge(arr, first, last, temp) {
    if(first<last) {
      let mid = Math.floor((first+last)/2);
      merge(arr, first, mid, temp);
      merge(arr, mid+1, last, temp);
      arr = mergeArray(arr, first, mid, last, temp);
    }
    return arr;
  }


  let arr = [3, 1, 4, 1, 5, 9, 2, 6];
  let temp = new Array();
  let CompareArr = merge(arr, 0 ,arr.length-1, temp);
  console.log(CompareArr);