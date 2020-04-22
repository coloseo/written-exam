const PENDING = 'pending'
const RESOLVED = 'resolved'
const REJECTED = 'rejected'
const MODEL = Symbol('model')
const SUCCESSCALLBACK = Symbol('successCallback')
const FAILURECALLBACK = Symbol('failureCallback')
class selfPromise {
    constructor(callBack) {
        this[MODEL] = PENDING
        this[SUCCESSCALLBACK] = []
        this[FAILURECALLBACK] = []
        callBack(this.__resolve.bind(this), this.__reject.bind(this))
        return this
    } 

    then(...callBacks) {
        let successCallback = null
        let failureCallback = null
        let returnArg = null
        let model = this[MODEL]
        let value = this.value
        if (callBacks.length === 1) {
            successCallback = callBacks[0]
            if(typeof successCallback !== 'function'){
                successCallback = function(){}
            }
        }
        
        if (callBacks.length === 2){
            successCallback = callBacks[0]
            if(typeof successCallback !== 'function'){
                successCallback = function(){}
            }
            failureCallback = callBacks[1]
            if(typeof failureCallback !== 'function'){
                failureCallback = function(){}
            }
        }
        return new selfPromise((res, rej) => {
            function resolved(value){
                setTimeout(() => {
                    let returnArg = successCallback(value)
                    if(returnArg instanceof selfPromise){
                        returnArg.then(res, rej)
                    }else{
                        if(typeof rej === 'function'){
                            res(returnArg)
                        }
                    }
                }, 0);
            }
            function rejected(value){
                setTimeout(()=>{
                    let returnArg = failureCallback(value)
                    if(returnArg instanceof selfPromise){
                        returnArg.then(res, rej)
                    }else{
                        res(returnArg)
                    }
                }, 0)
            }
            if(model === PENDING){
                this[SUCCESSCALLBACK].push(resolved)
                if (rej) this[FAILURECALLBACK].push(rejected)
            }
            if(model === RESOLVED){
                resolved(value)
            }
            if(model === REJECTED){
                rejected(value)
            }
        })
    }

    catch(failureCallback) {
        return this.then(undefined, failureCallback)
    }

    __resolve(value) {
        setTimeout(() => {
            if (this[MODEL] === PENDING) {
                this[MODEL] = RESOLVED
                this.value = value
                for (let i = 0; i < this[SUCCESSCALLBACK].length; i++) {
                    this[SUCCESSCALLBACK][i](value)
                }
                this[SUCCESSCALLBACK] = []
            }
        }, 0);
    }

    __reject(error) {
        setTimeout(() => {
            if (this[MODEL] === PENDING) {
                this[MODEL] = REJECTED
                this.value = error
                for (let i = 0; i < this[FAILURECALLBACK].length; i++) {
                    this[FAILURECALLBACK][i](error)
                }
                this[FAILURECALLBACK] = []
            }
        }, 0);
    }
}

module.exports = selfPromise