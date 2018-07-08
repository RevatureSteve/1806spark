/* 
console.log("i=: " + i);
console.log("The fibonnaci number for " + i + " is: " + fibSeries(i));
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

var n;

function fibSeries(n) {

    if (n == 0 || n == 1) {
        return n;
    }
    else
        return fibSeries(n - 2) + fibSeries(n - 1);
}

function printFibSeries(n) {
    for (var i = 0; i < n; i++) {
        console.log("i=: " + i);
        console.log("The fibonnaci number for " + i + " is: " + fibSeries(i))
        console.log("");
    }
    console.log("i=: " + i);
    console.log("The fibonnaci of " + i + " is: " + fibSeries(n));  
    console.log("");
}