// 1.编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
		function reverse(s){
			var arr = s.split("");
			var len = arr.length;
			function  arrs(arr){
				if(len>1){
					for(var i=0;i<len;i++){
						var temp=arr[i];
						arr[i]=arr[i+1];
						arr[i+1]=temp;
					}
					len--;
					arrs(arr);
				}else{
					s = arr.join("");
					console.log(s)
					return s;
				}
			}
			arrs(arr)
		}
		var s="abcde";
		reverse(s);
		
		
		
// 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *
		function expr(arr) {
			var result = 0;
			var temp = new Array(100);
			var tempNum = -1;
			var len = arr.length;
			for(var i = 0; i < len; i ++) {
				if(arr[i].match(/\d/)) {
					tempNum ++;
					temp[tempNum] = arr[i];
				} else {
					switch(arr[i]) {
						case "+": 
						result = (temp[tempNum-1] * 1)+ (temp[tempNum] * 1);
						tempNum --;
						temp[tempNum] = result;
						break;
						case "-": 
						result = (temp[tempNum-1] * 1) - (temp[tempNum] * 1);
						tempNum --;
						temp[tempNum] = result;
						break;
						case "*": 
						result = (temp[tempNum-1] * 1) * (temp[tempNum] * 1);
						tempNum --;
						temp[tempNum] = result;
						break;
						case "/": 
						result = (temp[tempNum-1] * 1) / (temp[tempNum] * 1);
						tempNum --;
						temp[tempNum] = result;
						break;
					}
				}
			}
			result = temp[tempNum];
			return result;
		}
		var str = "234+*";
		console.log(expr(str));
		

// 用归并排序将3，1，4，1，5，9，2，6 排序。
		function mergeSort(arr) {
			var len = arr.length;
			if(len < 2) {
				return arr;
			}
			var mid = Math.floor(len / 2);
			var left = arr.slice(0, mid);
			var right = arr.slice(mid, len);
			return merge(mergeSort(left), mergeSort(right));
		}
		function merge(left, right) {
			var result = [];
			while(left.length > 0 && right.length > 0) {
				if(left[0] <= right[0]) {
					result.push(left.shift());
				} else {
					result.push(right.shift());
				}
			}
			while(left.length) {
				result.push(left.shift());
			}
			while(right.length) {
				result.push(right.shift());
			}
			return result;
		}
		var arr = [3,1,4,1,5,9,2,6];
		console.log(mergeSort(arr));


		
		
// 对下面的 json 字符串 serial 相同的进行去重。
		var str = [{
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
			function newstr(str){
				var newstr = [];
				if(str.length>0){
				for(var i=0;i<str.length-1;i++){
					for(var j=i+1;j<str.length;j++){
						if(str[i].serial==str[j].serial){
							str.splice(j,1);
							j--;
						}else{
							
						}
					}
				}
				}
				console.log(str);
			}
			newstr(str)




		// 把下面给出的扁平化json数据用递归的方式改写成组织树的形式
		var str = [
			{
			  "id": "1",
			  "name": "中国",
			  "code": "110",
			  "parent": "",
			},
			{
			  "id": "2",
			  "name": "北京市",
			  "code": "110000",
			  "parent": "110",
			},
			{
			  "id": "3",
			  "name": '河北省',
			  "code": '130000',
			  "parent": '110',
			},
			{
			  "id": "4",
			  "name": "四川省",
			  "code": "510000",
			  "parent": "110",
			},
			{
			  "id": "5",
			  "name": "石家庄市",
			  "code": "130001",
			  "parent": "130000",
			},
			{
			  "id": "6",
			  "name": "唐山市",
			  "code": "130002",
			  "parent": "130000",
			},
			{
			  "id": "7",
			  "name": "邢台市",
			  "code": "130003",
			  "parent": "130000",
			},
			{
			  "id": "8",
			  "name": "成都市",
			  "code": "510001",
			  "parent": "510000",
			},
			{
			  "id": "9",
			  "name": "简阳市",
			  "code": "510002",
			  "parent": "510000",
			},
			{
			  "id": "10",
			  "name": "武侯区",
			  "code": "51000101",
			  "parent": "510001",
			},
			{
			  "id": "11",
			  "name": "金牛区",
			  "code": "51000102",
			  "parent": "510001",
			},
		  ];
			function getTree(arr, parentid) {
				var result = [];
				var temp = "";
				for(var i = 0; i < arr.length; i ++) {
					if(arr[i].parent == parentid) {
						var obj = arr[i];
						temp = getTree(arr, arr[i].code);
						if(temp.length > 0) {
							obj.children = temp;
						}
						result.push(obj);
					}
				}
				return result;
			}
			console.log(getTree(str, "110"));
