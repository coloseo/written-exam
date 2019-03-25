//1.编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
function handleReverse(s){
  let arr = s.split('');
  let len = arr.length;
  if(len>1){
      for(let i=0;i<(len-1)/2;i++){
          let temp = arr[i];
          arr[i] = arr[len-1-i];
          arr[len-1-i] = temp;
      }
  }
  let str = arr.join('');
  console.log('1、'+str);
  return str;
}

//2.编写程序 expr，以计算从命令行输入的逆波兰表达式的值，
// 其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *
function expr(arr){
    let reg=/[\+,\-,\*,\/,\%]/;
    if(arr.length>1){   //length要么1要么一定大于等于3
        for(let i=2;i<arr.length;i++){  //第一个数一定是数字。
            if(reg.test(arr[i])){ //是否是运算符
                let x = arr[i-2]+arr[i]+arr[i-1];
                arr.splice(i-2,3,(eval(x)+''));
                // console.log(arr[i-2]);
                expr(arr);
            }
        }
    }
    return arr;
}
function handleExpr(s){
    let arr = s.split(' ');
    let a = expr(arr);
    console.log('2、'+a[0]);
    return a[0];
}


//3.用归并排序将3，1，4，1，5，9，2，6 排序。
function sort(a,b){
    let arr = [];
    while(a.length&&b.length){
        if (a[0] < b[0]){
            arr.push(a.shift()); //去除第一个元素并返回第一个元素
        } else{
            arr.push(b.shift());
        }
    }
    return arr.concat(a, b); //考虑a,b其中一个长度0另一个长度1的情况，即排序长度为奇数
}
function handleSort(arr){
    let len = parseInt(arr.length/2);
    if(arr.length>1){
        let a = arr.slice(0,len);
        let b = arr.slice(len);
        arr = sort(handleSort(a),handleSort(b));
    }
    return arr;
}

//4.对下面的 json 字符串 serial 相同的进行去重。
function handleSerial(s){
    if(s.length>1){
        for(let i=0; i<s.length-1;i++){
            for(let j=i+1; j<s.length;j++){
                if(s[i].serial == s[j].serial){
                    s.splice(j,1); //删除j位置的，就有后面的元素替补，所以要退一步
                    j--;
                }
            }
        }
    }
    console.log('4、');
    console.log(s);
    return s;
}

//5.把下面给出的扁平化json数据用递归的方式改写成组织树的形式
//遍历
function Tree(s){
    let ind = 0 ;
    if(s.length>1){
        for(let i=0;i<s.length;i++){
            let a = 0;  //计数信号量
            for(let j=i+1;j<s.length;j++){
                if(s[j].parent == s[i].code){//判断是否有子树
                    a++;
                    ind++;
                }
            }
            if(a == 0&&s[i].parent!=''){ //没有子树
                for(let n in s){
                    s[n].children = s[n].children?s[n].children:[];
                    if(s[n].code == s[i].parent){
                        s[n].children.push(s[i]);
                        // s.splice(s[i],1);//删除,避免可能有多个父,循环结束后再删除
                    }
                }
                s.splice(i,1);//删除
                i--;
            }
        }
        if(ind != 0){
            Tree(s);
        }
    }
    return s;
}
function handleTree(s){ //先找到树的最底层
    s = Tree(s);
    console.log('5、');
    console.log(s);
    return s;
}

