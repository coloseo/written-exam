* types & grammar
  1. 判断以下结果
     #+BEGIN_SRC javascript
     var s = 'abc';
     s[1] = 'B';

     console.log(s);
输出：abc

     var l = new String('abc');
     l[1] = 'B';
     console.log(l);
输出：{
        0:"a"
        1:"b"
        2:"c"
     }
     #+END_SRC

  2. 如何逆序一个字符串？
可将字符串转化为数组后用数组的方法reverse
str.split('').reverse()

  3. 接上，为什么不能直接使用
     #+BEGIN_SRC javascript
     Array.prototype.reverse.call(str)
     #+END_SRC
     逆序字符串？
字符串没有reverse方法，要将其转为数组

  4. 判断以下结果，为什么会出现这样的情况，如何做出正确的比较？
     #+BEGIN_SRC javascript
     0.1 + 0.2 === 0.3;
     0.8 - 0.6 === 0.3;
     #+END_SRC

  5. 如何判断一个数值为整数？
可将该数值做向上取整或向下取整，在与原值做===比较

  6. 如何判断一个数值为+0？
可用正则表达式以0结束

  7. 以下代码中'abc'作为primitive value, 如何访问toUpperCase 方法?
     #+BEGIN_SRC javascript
     'abc'.toUpperCase();
     #+END_SRC

  8. 判断以下结果
     #+BEGIN_SRC javascript
     Array.isArray(Array.prototype);
     #+END_SRC

  9. 判断以下结果
     #+BEGIN_SRC javascript
     Boolean(Boolean(false));
     Boolean(document.all);

     [] == '';
     [3] == 3;
     [] == false;
     42 == true;
     #+END_SRC

  10. 找出以下代码问题(TDZ)
      #+BEGIN_SRC javascript
      var a = 3;
      let a;
      #+END_SRC
在es6中，使用let声明变量只能被声明一次

  11. 找出以下代码问题(TDZ)
      #+BEGIN_SRC javascript
      var b = 3;
      function foo(a = 42, b = a + b + 5) {
        // ..
      }

      foo();
      #+END_SRC

* scope & closures

  1. var a = 2 中, Engine, Scope, Compiler 做了什么工作?

  2. 判断以下结果(lexical scope)
     #+BEGIN_SRC javascript
     var scope = 'global scope';
     function checkscope() {
         var scope = 'local scope';
         function f() {
           return scope;
         }
         return f;
     }
     #+END_SRC

  3. 判断以下结果(Hoisting)
     #+BEGIN_SRC javascript
     console.log(a);
     var a = 3;
     #+END_SRC
输出：undefined

  4. 判断以下结果(Function First)
     #+BEGIN_SRC javascript
     var foo = 1;
     function foo() {}
     console.log(foo);
     #+END_SRC
输出：1

  5. 判断以下结果(IIFE & Function First)
     #+BEGIN_SRC javascript
     var foo = 1;
     (function () {
       foo = 2;
       function foo (){
       }
       console.log(foo);
     })()
     console.log(foo);
     #+END_SRC
输出：2  1

  6. 判断以下结果，如何按序输出(Closure)
     #+BEGIN_SRC javascript
     for (var i = 0; i < 10; i++) {
       setTimeout(function () {
         console.log(i);
       }, i * 1000);
     }
     #+END_SRC
输出：十个10

* this & object prototypes
  1. 判断以下结果(Default Binding)
     #+BEGIN_SRC javascript
     function foo() {
       "use strict"
       console.log(this.a);
     }
     var a = 2;

     foo();
     #+END_SRC
严格模式下，未声明的变量会报错
  2. 判断以下结果
     #+BEGIN_SRC javascript
     "use strict"
     var a = 2;
     console.log(this);
     #+END_SRC
全局作用域下，this指向window

  3. 判断以下结果(strict mode & default binding)
     #+BEGIN_SRC javascript
     function foo() {
       console.log(this.a);
     }
     var a = 2;
     (function(){
       "use strict"
       foo();
     })();
     #+END_SRC
严格模式下，未声明的变量会报错

  4. 判断以下结果(hard binding)
     #+BEGIN_SRC javascript
     function foo() {
       console.log(this.a);
     }
     const o1 = { a: 3 };
     const o2 = { a: 4 };

     foo.bind(o1).bind(o2)();
     #+END_SRC
输出：3
  5. 如何实现
     #+BEGIN_SRC javascript
     Function.prototype.bind
     Function.prototype.softBind
     #+END_SRC

  6. new 的过程中发生了什么, 判断以下结果(new)
     #+BEGIN_SRC javascript
     function F() {
       this.a = 3;
       return {
         a: 4
       }
     }
     const f = new F();
     console.log(f.a);
     #+END_SRC

     输出：4
  7. 什么是data descriptor 和 accessor descriptor?

  8. 如何访问一个对象的属性与如何对一个对象的属性赋值(Get & Put)?
      可以使用“ . ”和“ [ ] ”来访问对象的属性。
      获取到属性后可用等号赋值
  9. 如何遍历一个对象(iterator)?
      1、for 循环遍历
      2、JavaScript 提供了 foreach(可遍历 Array对象
      Array.forEach(function(value , index , array){ })
      3、for...in来枚举获得

  10. 如何实现一个继承(Object.create & call)?
  可利用call或者apply来实现继承
      var obj = new Object();
      sayColor.call(obj, 参数);

  11. 如何实现 __proto__?
      function Foo(){}
      Foo.prototype = Boo;
      var f = new Foo();
      f.__proto__ === Foo.prototype
  12. 如何实现Object.create?
      const person = {
      name: "li",
      printname: function () {
         console.log(this.name);
      }
      };
      const me = Object.create(person);
      me.name = "TL";
      me.printname();


# 笔试题

请完成以下笔试题，可以使用自己擅长的语言来编写，通过 github pull request 提交代码。

1. 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
  function func(x,index,str){
          return index == 0 ? str : func(x,--index,(str +=" " + x[index]));;
        }
        var arr = "abcd";
        var arr3 = func(arr,arr.length,"");

2. 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令
expr 2 3 4 + *

3. 用归并排序将3，1，4，1，5，9，2，6 排序。
        function merge(left, right) {
            var tmp = [];
            while (left.length && right.length) {
                if (left[0] < right[0])
                    tmp.push(left.shift());
                else
                    tmp.push(right.shift());
            }
            return tmp.concat(left, right);
        }
        function mergeSort(a) {
            if (a.length === 1)
                return a;
            var mid = Math.floor(a.length / 2);
                left = a.slice(0, mid),
                right = a.slice(mid);
            return merge(mergeSort(left), mergeSort(right));
        }
        console.log(mergeSort([3,1,4,1,5,9,2,6 ]))

4. 对下面的 json 字符串 serial 相同的进行去重。
function filterObj(objcArray){
                for (var i = 0; i < objcArray.length; i++) {
                    for (var j =i+1; j <objcArray.length; ) {
                        if (objcArray[i].serial == objcArray[j].serial ) { //通过id属性进行匹配；
                        objcArray.splice(j, 1); //去除重复的对象；
                        }else {
                        j++;
                        }
                    }
                    }
                    return objcArray;
            }

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
