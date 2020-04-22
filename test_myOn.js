const event = require('./myOn')

let test = new event('self')
function myConsole(msg){
    console.log(msg)
}
test.on('log', myConsole).target('log', myConsole.name, 1)

test.on('log', myConsole).target('log', myConsole.name, 1).target('log')