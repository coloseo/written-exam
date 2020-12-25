Res('abcdefg')
function Res(s){
    let arr = s.split('');
    let length = arr.length;
    let ar = [];
    let answer = reverse(arr,length,ar).join('');
    console.log(answer);
}

function reverse(arr,length,ar){
    if(length>=1){
       let newarr = arr.shift();
       ar[length-1] = newarr;
       length=length-1;
       reverse(arr,length,ar);
    }
    return ar;
}