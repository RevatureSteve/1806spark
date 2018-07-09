console.log('Feel free to use the pre-initialized array, "fourHorsemen" for exercises 10 and 11');

let fourHorsemen = ["conquest", "famine", "pestilence", "death"];

console.log("");
console.log( "1. Fibonacci");
console.log("Define function: fib(n)");
console.log("Return the nth number in the fibonacci sequence");

function fib(n) {
    let a=0, b=1, c=1;
    for (let i=2;  i<=n; i++)
    {
        c=a+b;
        a=b;
        b=c;
    };
return c;
};

console.log("");
console.log("4. Factorial:");
console.log("Define function: factorial(someNum)");
console.log("Use recursion to compute and return the factorial of someNum.");

function factorial(someNum) {
    let x=someNum;
    for (let i=someNum-1; i>0; i--)
    {
        x=x*i;
    };
return x;
};

console.log("");
console.log("10. Delete Element");
console.log("Define function deleteElement(someArr)");
console.log("Print length");
console.log("Delete the third element in the array.");
console.log("Print length");
console.log("The lengths should be the same.");

function deleteElement(someArr) {
    console.log("The original length of " + someArr + " is " + someArr.length);
    someArr[2] = null;
    return("The final length of " + someArr + " is " + someArr.length);
}

console.log("");
console.log("11. Splice Element");
console.log("Define function spliceElement(someArr)");
console.log("Print length");
console.log("Splice the third element in the array.");
console.log("Print length");
console.log("The lengths should be one less than the original length.");

function spliceElement(someArr2) {
    console.log("The original length of " + someArr2 + " is " + someArr2.length);
    someArr2.splice(2,1);
    return ("The final length of " + someArr2 + " is " + someArr2.length);
};

/* I would like to be able to have examples 10 and 11 refer
to the array by its name rather than its contents
but I can't figure out how. As it stands, my code fufills
the requirements asked for so, good enough I guess.*/