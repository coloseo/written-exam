Function.prototype.__bind = function (that, ...arr1) {
    if (Object.prototype.toString.call(this) !== '[object Function]') {
        throw new Error('Bind must be called on a function')
    }
    let __this = that;
    let __fnc = this;
    let __arr1 = arr1;
    let returnFnc = function (...arr2) {
        if (new.target) {
            __this = this
        }
        return __fnc.call(__this, ...__arr1.concat(arr2));
    }
    let __prototype = function () { }
    __prototype.prototype = __fnc.prototype
    returnFnc.prototype = new __prototype()
    return returnFnc
}

const __module = {
    x: 42,
    getX: function (...val) {
        if (val) console.log(val)
        return this;
    }
}

const unboundGetX = __module.getX;
// expected output: undefined

const boundGetX = unboundGetX.__bind(new Object({ a: 1 }), [1, 2]);
console.log(new boundGetX([4, 5]));

let a = {};
a.__proto__.__bind = Function.prototype.bind
//console.log(a.__bind({},[1,2])) 报错是否成功
function Point(x, y) {
    this.x = x;
    this.y = y;
}

Point.prototype.toString = function () {
    return this.x + ',' + this.y;
};

var p = new Point(1, 2);
console.log(p.toString()) // '1,2'

var emptyObj = {};
const YAxisPoint = Point.__bind(emptyObj, 0/*x*/);

var axisPoint = new YAxisPoint(5);
console.log(axisPoint.toString()); // '0,5'

console.log(axisPoint instanceof Point) // true
console.log(axisPoint instanceof YAxisPoint) // true
console.log(new YAxisPoint(17, 42) instanceof Point) // true

function LateBloomer() {
    this.petalCount = Math.floor(Math.random() * 12) + 1;
}

// Declare bloom after a delay of 1 second
LateBloomer.prototype.bloom = function () {
    setTimeout(this.declare.__bind(this), 1000);
};

LateBloomer.prototype.declare = function () {
    console.log(`I am a beautiful flower with ${this.petalCount} petals!`);
};

const flower = new LateBloomer();
flower.bloom();
  //  after 1 second, calls 'flower.declare()'