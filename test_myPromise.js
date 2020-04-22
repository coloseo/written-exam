const Promise = require('./myPromise')
const promisesAplusTests = require("promises-aplus-tests");
Promise.defer = Promise.deferred = function () {
    let dfd = {};
    dfd.promise = new Promise((resolve, reject) => {
        dfd.resolve = resolve;
        dfd.reject = reject;
    });
    return dfd;
}
promisesAplusTests(Promise, function (err) {
    // All done; output is in the console. Or check `err` for number of failures.
},{},'2.3.3.js');