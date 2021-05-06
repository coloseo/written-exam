# 笔试题  

请完成以下笔试题，可以使用自己擅长的语言来编写，通过 github pull request 提交代码。

1. 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
package written;

public class ReverseTest {
    public static String reverse(String str) {

        if ((null == str)||(str.length() <= 1)){
            return str;
        }
        /*
        * substring:源码解析
    *  public String substring(int beginIndex) {
        if (beginIndex < 0) {
            throw new StringIndexOutOfBoundsException(beginIndex);
        }
        int subLen = value.length - beginIndex;
        if (subLen < 0) {
            throw new StringIndexOutOfBoundsException(subLen);
        }
        * 每一次截取字符串 ，从beginIndex开始 ，长度为subLen
        return (beginIndex == 0) ? this : new String(value, beginIndex, subLen);
    }
        * */
        return reverse(str.substring(1))+str.charAt(0);
    }

    public static void main(String[] args) {
        String str = "string";
        System.out.println(reverse(str));

    }
}

2. 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令
expr 2 3 4 + *
package written;

import java.util.Scanner;
import java.util.Stack;

public class expr {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(polen(str));
    }
/*
* 根据输入的逆波兰表达式，将重新进行入栈操作
*
* */
    public static int polen(String str){
        String[] arr = str.split(" ");
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("*") || arr[i].equals("/")){
                int right = s.pop();
                int left = s.pop();
                switch(arr[i]){
                    case "+":
                        s.push(left + right);
                        break;
                    case "-":
                        s.push(left - right);
                        break;
                    case "*":
                        s.push(left * right);
                        break;
                    case "/":
                        s.push(left / right);
                        break;
                    default:
                        break;
                }
            }else{
                int num = Integer.parseInt(arr[i]);
                s.push(num);
            }
        }
        return s.pop();
    }
}

3. 用归并排序将3，1，4，1，5，9，2，6 排序。
package written;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] arr = new int[]{3,1,4,1,5,9,2,6};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    //本质采用递归的方式，拆分---组合排序
    public static void mergeSort(int[] arr,int low,int high){
        int middle=(high+low)/2;
        if(low<high) {
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }
    public static void merge(int[] arr,int low,int middle,int high){
        //用于存储归并后的临时数组
        int[] temp = new int[high-low+1];
        //记录第一个数组中需要遍历的下标
        int i = low;
        //记录第二个数组中需要遍历的下标
        int j = middle+1;
        //记录在临时数组中存放的下标
        int index = 0;
        //遍历两个数组，取出小的数字，放入临时数组,下标++
        while (i<=middle&&j<=high){
            if (arr[i]<=arr[j]){
                temp[index] = arr[i];
                i++;
            }else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        while (j<=high){
            temp[index] = arr[j];
            j++;
            index++;
        }
        while (i<=middle){
            temp[index] = arr[i];
            i++;
            index++;
        }

        for (int c = 0; c < temp.length; c++) {
            arr[c+low] = temp[c];

        }
    }
}

4. 对下面的 json 字符串 serial 相同的进行去重。

```javascript
  [{
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
```


 functin unqiue(arr,attribute){
        var new_arr=[];
        var json_arr=[];
        for(var i=0; i<arr.length; i++){
            console.log(new_arr.indexOf(arr[i][attribute]));
            if(new_arr.indexOf(arr[i][attribute]) ==-1){    //  -1代表没有找到
                new_arr.push(arr[i][attribute]);   //如果没有找到就把这个name放到arr里面，以便下次循环时用
                json_arr.push(arr[i]);
            } else{
            }
        }
        return json_arr;
    }

//调用
var json=[
        {name:“张三”,serial:“0001”},
        {name:“李四”,serial:“0002”},
        {name:“王五”,serial:“0003”},
        {name:“王五2”,serial:“0003”},
        {name:“赵四”,serial:“0004”},
        {name:“小明”,serial:“0005”},
        {name:“小张”,serial:“0006”},
        {name:“小李”,serial:“0006”},
        {name:“小李2”,serial:“0006”},
        {name:“赵四2”,serial:“0004”}];
        var new_json=unique(json,“serial”);
        console.log(new_json);

5. 把下面给出的扁平化json数据用递归的方式改写成组织树的形式

```javascript
  [
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
```
function Tree(s){
    let ind = 0 ; //判断第一层是不是还有子树
    if(s.length>1){
        for(let i=0;i<s.length;i++){
            let a = 0;  //计数信号量
            for(let j=i+1;j<s.length;j++){
                if(s[j].parent == s[i].code){//判断是否有子树
                    a++;  //子树计数
                    ind++;
                }
            }
            if(a == 0&&s[i].parent!=''){ //没有子树，即树的最底层
                for(let n in s){
                //定义children，避免undefined
                    s[n].children = s[n].children?s[n].children:[];
                    if(s[n].code == s[i].parent){
                        s[n].children.push(s[i]);
                    }
                }
                s.splice(i,1);//删除，该子树已经加入了某项底层
                i--; //删掉子树后后面的数据会填补空缺，退一步才能遍历完全
            }
        }
        if(ind != 0){ //如果还有子树继续遍历第一层
            Tree(s);
        }
    }
    return s;
}
function handleTree(s){ 
    s = Tree(s);
    console.log(s);
    return s;
}