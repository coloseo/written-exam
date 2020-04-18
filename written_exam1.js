/**
 * Author: 张芸海
 */

 // 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
 function reverse(str='', index = str.length, reStr = []) {
     if(index){
         if(!Array.isArray(str))str=str.split('');
         reStr.push(str.pop())
         reverse(str,  --index, reStr)
         return reStr.join('');
     }else{
        return str;
     }
 }

console.log(reverse('zhangyunhai'))