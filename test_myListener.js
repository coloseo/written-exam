const myListener = require('./myListener')

let a1 = new myListener({a:1, b:2})
function getName(){
    console.log(this.name)
}
function setName(value){
    this.name = value
}
a1.regist('a', setName).regist('a', getName.bind({name: 'zhang'}))
a1.regist('a', getName)
a1.a = 2
a1.a = 3
console.log(a1.a)
a1.remove('a')
a1.a = 4
a1.regist('b', setName).regist('b', getName).regist('a', setName).regist('a', getName)
a1.b = 5
a1.b = 6
a1.a = 7
a1.a = 8
a1.remove()
console.log(a1)