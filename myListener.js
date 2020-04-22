const keyFnc = Symbol('keyFnc')
const registKey = Symbol('registKey')
const defineObj = Symbol('defineObj')
class myListener{
    constructor(obj){
        for(let key in obj){
            this[key] = obj[key]
        }
        this[keyFnc] = new Map()
        this[registKey] = new Set()
        this[defineObj] = {}
        return this
    }
    regist(...arg){
        if(arg.length === 0){
            throw new Error('Function regist parameter cannot be empty')
        }
        let key = arg[0]
        let Fnc = arg.slice(1)
        if(this[keyFnc].has(key)){
            let setFnc = this[keyFnc].get(key)
            Fnc.forEach((fnc)=>{
                setFnc.add(fnc)
            })
        }else{
            let setFnc = new Set()
            Fnc.forEach((fnc)=>{
                setFnc.add(fnc)
            })
            this[keyFnc].set(key, setFnc)
            registObj(this, setFnc, key)
        }
        this[registKey].add(key)
        return this
    }
    
    remove(...arg){
        if(arg.length === 0){
            removeObj(this, Array.from(this[registKey]))
        }else{
            removeObj(this, arg)
        }
        return this
    }
}

function registObj(that, fncSet, key){
    let fncs = fncSet
    Object.defineProperty(that,key,{
        set(newValue){
            for(let fnc of [...fncs]){
                fnc(newValue)
            }
            that[defineObj][key] = newValue
        },
        get(){
            return that[defineObj][key]
        }
    })
}
function removeObj(that, keys){
    keys.forEach((key)=>{
        that[registKey].delete(key)
        that[keyFnc].delete(key)
        Object.defineProperty(that, key, {
            set(newValue){
                that[defineObj][key] = newValue
            },
            get(){
                return that[defineObj][key]
            }
        })
    })
}

module.exports = myListener