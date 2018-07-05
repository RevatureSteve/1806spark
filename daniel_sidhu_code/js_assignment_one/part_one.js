console.log('Daniels Part 1 is loaded');

/*
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function fib(n) {
    var f = 0; //first var declared
    var s = 1; //second var declared
    var sum;   //sum  var declared 

    for (var i = 0; i < n; i++) {
        sum = f + s;
        f = s;
        s = sum;
        console.log('value ' + i + ' is ' + sum); //print statement
    }
    return sum;
}
