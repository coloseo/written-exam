# 笔试题  

请完成以下笔试题，可以使用自己擅长的语言来编写，通过 github pull request 提交代码。

1. 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
```javascript
#include <stdio.h>
int swap(char *s,char *p)//递归
{
   int i = 0;
   char temp;//中间变量
   if(*++p != '\0')
   {
      i=swap(s,p);
   }
   if((s+i)<=(--p))
   {
      temp=*(p);
      *(p)=*(s+i);
      *(s+i)=temp;
   }
   return ++i;
}

char *reverse(char *s)
{
   char *p,*q;
   p=q=s;
   swap(q,p);
   return s;
}

int main(void)
{
   char s[] = "Can I do it?";
   printf("%s\n",reverse(s));
   return 0;
}
```
2. 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令
expr 2 3 4 + *

3. 用归并排序将3，1，4，1，5，9，2，6 排序。
```javascript
#include <stdio.h>
void div(int[] data)
{
  if (data.length>1) 
  {
    int[] firstArr=new int[data.length/2];//第一个数组
    int[] secondArr=new int[data.length-data.length/2];//第二个数组
    int i,j,k;
    for(i=0;i<firstArr.length;i++) 
	{
      firstArr[i] = data[i];
    }
    for(k=0,j=data.length/2;k<secondArr.length;j++,k++) 
	{
      secondArr[k] = data[j];
    }
    div(firstArr);//递归
    div(secondArr);
    for(i=0;i<firstArr.length;i++) 
	{
      data[i]=firstArr[i];
    }
    for(k=0,j=data.length/2;m<secondArr.length;j++,k++) 
	{
      data[j]=secondArr[k];
    }
     mergeSort(data);//归并排序      
  }
}
void mergeSort(int[] data)
{
  int mid=data.length/2; 
  int k=0;
  int first;
  int second;
  int[]tempArr=new int[data.length];  
  for (first=0,second=mid;first<mid&&second<data.length ; ) 
  {
    if (data[first]<data[second]) 
	{
       tempArr[k]=data[first];
       k++;
       first++;
    }
	else 
	{
       tempArr[k]=data[second];
       k++;
       second++;
     }
  }
  if (first>=mid) 
  {
    while (k<data.length) 
	{
      tempArr[k]=data[second];
      k++;
      second++;
     }
   }
   else 
   {
      while (k<data.length) 
	 {
      tempArr[k]=data[first];
      k++;
      first++;
     }
   }
   for(int i=0;i<data.length;i++) 
   {
    data[i]=tempArr[i];
   }       
}
int main(void)
{
    int[] data={3,1,4,1,5,9,2,6};//原始数据
	int i=0;
    div(data);
    for(;i<data.length;i++) 
	{
      System.out.print(data[i]+" ");          
    }
}
```

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
```javascript
function handleSerial(s){
    if(s.length>1){
        for(let i=0; i<s.length-1;i++){
            for(let j=i+1; j<s.length;j++){
                if(s[i].serial== s[j].serial){
                    s.splice(j,1); //删除j位置的数据项并退一步
                    j--;
                }
            }
        }
    }
    console.log(s);
    return s;
}
```
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
```javascript
function Tree(s)
{
    let ind=0 ;
    if(s.length>1)
	{
        for(let i=0;i<s.length;i++)
		{
            let a=0;
            for(let j=i+1;j<s.length;j++)
			{
                if(s[j].parent==s[i].code)
				{
                    a++; 
                    ind++;
                }
            }
            if(a==0&&s[i].parent!='')
			{ 
                for(let n in s){
                    s[n].children=s[n].children?s[n].children:[];
                    if(s[n].code==s[i].parent)
					{
                        s[n].children.push(s[i]);
                    }
                }
                s.splice(i,1);
                i--; 
            }
        }
        if(ind != 0)
		{ 
            Tree(s);
        }
    }
    return s;
}
function handleTree(s)
{ 
    s=Tree(s);
    console.log(s);
    return s;
}
```