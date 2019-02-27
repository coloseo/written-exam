 
* 1. 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
```javasceipt
function newReverse(str){
	var len=str.length;
	if (len>1){
		return newReverse(str.substring(1,len)) + str[0]
	}
	else{
		return str[0] ;
	}
};
console.log(newReverse("?rewsna thgir ti sI"));
```
2. 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。 
```javasceipt
//#!/usr/bin/env node
function expr(argv){
	var len=argv.length;
	if(len>2){
		var stack=[];
		for(var i=2;i<len;i++){
			var arg=argv[i];
			var num=Number(arg);
			if(isNaN(num)){
				var n1 = Number(stack.splice(stack.length-1,1));
				var n2 = Number(stack.splice(stack.length-1,1));         
				switch (arg){
					case '+':
					    num=n1+n2;
						break;
					case '-':
					    num=n1-n2;
						break;
					case '*':
					    num=n1*n2;
						break;
					case '/':
					    num=n1/n2;
						break;
					default:  
					    return "wrong operator!";
				}	
			}
			stack.push(num);
		}
		return stack[0];
	}else return "need more operators!";
};
console.log(expr(process.argv));
```



  3. 用归并排序将3，1，4，1，5，9，2，6 排序 
```javasceipt
function merge(arr1,arr2){
	var mergedArr = [];
	while(arr1.length>0 || arr2.length>0){
		if(arr1[0]>arr2[0] || arr2.length==0){
		mergedArr.push(arr1[0]);
		arr1.splice(0,1);
		}else {
		mergedArr.push(arr2[0]);
		arr2.splice(0,1);
		}
	} 
	return mergedArr;
}

function mergeSort(arr){
	if(arr.length>1){
		return merge(mergeSort(arr.slice(0,arr.length/2)),mergeSort(arr.slice(arr.length/2,arr.length)));
	}
	else return arr;        
}
var q3=[3,1,4,1,5,9,2,6 ];
console.log(mergeSort(q3));
```

4. 对下面的 json 字符串 serial 相同的进行去重。 
```javasceipt
function duplicateRemoval(jsonArr){
	var dictionary=[];
	for(var i in jsonArr){
		if(!dictionary[jsonArr[i].serial]){
			dictionary[jsonArr[i].serial]=1;
		}
		else {
			delete jsonArr[i];
		}
	}
	return jsonArr;

}

var q4= [
    {
    "name": "张三",
    "serial": "0001"
}, {
    "name": "李四",
    "serial": "0002"
}, {
    "name": "王五",
    "serial": "0003"
}, {
    "name": "王五2",
    "serial": "0003"
}, {
    "name": "赵四",
    "serial": "0004"
}, {
    "name": "小明",
    "serial": "005"
}, {
    "name": "小张",
    "serial": "006"
}, {
    "name": "小李",
    "serial": "006"
}, {
    "name": "小李2",
    "serial": "006"
}, {
    "name": "赵四2",
    "serial": "0004"
}];
console.log(duplicateRemoval(q4));
```

 5. 把下面给出的扁平化json数据用递归的方式改写成组织树的形式。
```javasceipt
function foundChild(parent,jsonArr){
	for(i in jsonArr){
		if(jsonArr[i].parent===parent.code){
			if(!parent.hasOwnProperty('child')) parent.child=[];
			parent.child.push(jsonArr[i]);
			foundChild(parent.child[parent.child.length-1],jsonArr)
			delete jsonArr[i];
		}
	}
}

function buildTree(jsonArr){
	for(var i in jsonArr){
		foundChild(jsonArr[i],jsonArr);
	}
	return jsonArr[0];
}


var q5= [
    {
      "id": "1",
      "name": "中国",
      "code": "110",
      "parent": ""
    },
    {
      "id": "2",
      "name": "北京市",
      "code": "110000",
      "parent": "110"
    },
    {
      "id": "3",
      "name": "河北省",
      "code": "130000",
      "parent": "110"
    },
    {
      "id": "4",
      "name": "四川省",
      "code": "510000",
      "parent": "110"
    },
    {
      "id": "5",
      "name": "石家庄市",
      "code": "130001",
      "parent": "130000"
    },
    {
      "id": "6",
      "name": "唐山市",
      "code": "130002",
      "parent": "130000"
    },
    {
      "id": "7",
      "name": "邢台市",
      "code": "130003",
      "parent": "130000"
    },
    {
      "id": "8",
      "name": "成都市",
      "code": "510001",
      "parent": "510000"
    },
    {
      "id": "9",
      "name": "简阳市",
      "code": "510002",
      "parent": "510000"
    },
    {
      "id": "10",
      "name": "武侯区",
      "code": "51000101",
      "parent": "510001"
    },
    {
      "id": "11",
      "name": "金牛区",
      "code": "51000102",
      "parent": "510001"
    }
  ];


console.log(buildTree(q5));
```
