let json_4 = [{
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

let json_5 = [{
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
		"id": "11",
		"name": "金牛区",
		"code": "51000102",
		"parent": "510001"
	}
];

function reverse(str, str_re) {
	if(typeof str == 'string') {
		str = str.split('');
		str_re = '';
	}
	if(str[0]) {
		str_re += str.pop();
		reverse(str, str_re)
	} else {
		console.log(str_re)
		return str_re
	}
}
/**
 * 
 * @param {String} fun_str 方程字符串
 * @param {String} slt 间隔字符串，默认为 [空格]
 */
function expr(fun_str, slt) {
	let fun_arr;
	for(fun_arr = fun_str.split(slt || ' '); fun_arr[1]; fun_arr = to_cale(fun_arr)) {

	}
	return fun_arr[0]

	function to_cale(fun_array) {
		for(let k = -1; fun_array[++k];) {
			if(/[+\-*/xX]/.test(fun_array[k])) {
				let to_push = fun_array[k - 2] + fun_array[k].replace(/[xX]/g, '*') + fun_array[k - 1];
				fun_array.splice(k - 2, 3, eval(to_push));
				return fun_array;
			}
		}
		console.error('逆波兰方程式格式可能有误。')
	}
}

/** 归并排序  is_asc
 * 
 * @param {Object} re_array
 * @param {Boolean} is_asc 是否为升序
 */
function func_3(re_array, is_asc = !!1, kill_same = !!0) {
	re_array = typeof re_array === 'string' ? re_array.split('') : re_array;
	let merge_type = is_asc ? [0, 1] : [1, 0];
	if(re_array instanceof Array) {
		re_array = re_array.map((its) => {
			return [its]
		})
		do {
			re_array = to_do(re_array);
		} while (re_array[1])
		return re_array
	} else {
		console.error('格式有误')
	}

	function to_do(t_array) {
		let r_array = []
		for(let k = 0; t_array[k]; k += 2) {
			r_array.push(to_merge(t_array[k], t_array[k + 1]))
		}
		return r_array
	}

	function to_merge(array0, array1) {
		let re_array = [];
		if(!array1) {
			return array0
		}
		for(; array0[0] || array1[0];) {
			if(!array0[0]) {
				re_array.push(array1.shift())
				re_array
			} else if(!array1[0]) {
				re_array.push(array0.shift())
				re_array
			} else if(array0[0] < array1[0]) {
				re_array.push(arguments[merge_type[0]].shift())
			} else if(array0[0] > array1[0]) {
				re_array.push(arguments[merge_type[1]].shift())
			} else {
				if(!kill_same) {
					re_array.push(arguments[merge_type[1]].shift())
				} else {
					arguments[merge_type[1]].shift()
				}
			}
		}
		return re_array
	}
}

function func_4(t_json, id_name = 'serial') {
	if(t_json instanceof Array || t_json[0][id_name]) {
		let t_map = {};
		for(let k = 0; t_json[k];) {
			if(!t_map[t_json[k][id_name]]) {
				t_map[t_json[k][id_name]] = !!1;
				k++;
			} else {
				t_json.splice(k, 1)
			}
		}
		console.log(t_json)
	} else {
		console.error('输入格式不正确')
	}
}

function func_5(t_json, parent_name = 'parent', code_name = 'code') {
	let k;
	for(k = -1; t_json[++k];) {
		let par_name = t_json[k][parent_name];
		if(par_name) {
			set_children(t_json, k, par_name)
		}
	}

	function set_children(s_json, index, par_name) {
		for(let lc = -1; s_json[++lc];) {
			if(s_json[lc][code_name] == par_name) {
				s_json[lc].children = s_json[lc].children || [];
				s_json[lc].children.push(t_json.splice(index, 1)[0]);
				k--
			} else if(s_json[lc].children) {
				set_children(s_json[lc].children, index, par_name)
			}
		}
	}

	return t_json
}