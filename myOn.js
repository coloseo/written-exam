const onFunc = Symbol('onFunc')
const noArg = Symbol('noArg')

class event{
    constructor(val){
        this.val = val
        this[onFunc] = new Map()
        return this
    }

    on(type, fnc) {
        throwError(type, 'String', fnc, 'Function')
        setFunc(type, fnc, this)
        return this
    }

    once(type, fnc){
        throwError(type, 'String', fnc, 'Function')
        setFunc(type, fnc, this, true)
        return this
    }

    target(type, targer= '', arg=noArg, runNumber = 0, callBack=null, errCallBack=null){
        let fncModel = ''
        if(targer !== ''){
            fncModel = 'targer'
        }
        if(runNumber !== 0){
            fncModel = 'runNumber'
        }
        if(fncModel === 'targer'){
            runType(this, type, arg, targer, fncModel='targer', runNumber, callBack, errCallBack)
        }
        if(fncModel === 'runNumber'){
            runType(this, type, arg, targer, fncModel='runNumber', runNumber, callBack, errCallBack)
        }
        if(fncModel === ''){
            runType(this, type, arg, targer, fncModel='', runNumber, callBack, errCallBack)
        }
        return this
    }
}
function runType(that, type, arg, targer=null, fncModel='', runNumber=null, callBack=null, errCallBack=null){
    let __node = getFunc(type, that)
    if(fncModel === ''){
        runTime(__node, arg, errCallBack, runNumber)
    }
    if(fncModel === 'targer'){
        runTime(__node, arg, errCallBack, runNumber, targer)
    }
    if(fncModel === 'runNumber'){
        runTime(__node, arg, errCallBack, runNumber)
    }
    if(callBack)callBack()
}

function runTime(__node, arg, errCallBack, runNumber, targer){
    let keys = null
    let key = null
    let runNumbered = 0
    if(targer){
        keys = targer
    }else{
        keys = __node.keys()
    }
    key = getKey(keys, runNumbered)
    while(key !== undefined){
        let runNode = __node.get(key)
        try{
            if(arg === noArg){
                runNode.fnc()
            }else{
                runNode.fnc(arg)
            }
            runNumbered++;
        }catch(error){
            if(errCallBack)errCallBack(error)
        }
        if(runNode.once){
            __node.delete(key)
        }
        key = getKey(keys, runNumbered)
        if(runNumber){
            runNumber--
            if(runNumber === 0)return
        }
    }
    function getKey(keys, runNumbered){
        if(keys.next){
            return keys.next().value
        }else if(keys !== undefined && runNumbered === 0){
            return keys
        }else{
            return undefined
        }
    }
}

/**
 * 
 * @param {string} type 目标名称
 * @param {function|Array<function>} fnc 目标方法
 * @param {Object} this class实例
 * @param {boolean} once 是否为单次运行
 */
function setFunc(type, fnc, that, once=false){
    if(Array.isArray(fnc)){
        for(let i=0; i<fnc.length; i++){
            setFunc(type, fnc[i], that, once)
        }
    }
    let __typeNode = getFunc(type, that)
    let __setFnc = {
        once: once,
        fnc: fnc
    }
    if(fnc.name === '' || fnc.name === 'anonymous'){
        throwError(`don't support anonymous functions`);
    }
    if(__typeNode){
        __typeNode.set(fnc.name, __setFnc)
    }else{
        let __newMap = new Map()
        __newMap.set(fnc.name, __setFnc)
        that[onFunc].set(type, __newMap)
    }
}

/**
 * 
 * @param {string} type 目标名称
 * @param {Object} this event实例
 * @returns {Map<string, Object> | boolean} flase:没有设置过;Map: 函数Map
 */
function getFunc(type, that){
    let __node = that[onFunc].get(type)
    if(__node){
        return __node
    }else{
        return false
    }
}

function throwError(...errArr){
    if(errArr.length === 1){
        throwError(errArr[0])
    }
    for(let i=0; i<errArr.length; i+=2){
        if(Array.isArray(errArr[i])){
            for (let i = 0; i < errArr[i].length; i++) {
                throwError(errArr[i][i], errArr[i+1])
            }
        }
        let type = isType(errArr[i])
        if(!isType(errArr[i], errArr[i+1])){
            errorMsg(`parameter of the on ${type} should be ${errArr[i+1]}`)
        }
    }
}

function isType(value, type = ''){
    if(type === ''){
        return Object.prototype.toString.call(value)
    }
    type.replace(/^\S/, s => s.toUpperCase())
    type = `[object ${type}]`
    let __istype = Object.prototype.toString.call(value)
    if(type === __istype){
        return true
    }else{
        return false
    }
}


function errorMsg(msg){
    throw new Error(msg)
}

module.exports = event