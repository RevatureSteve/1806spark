var cat = "cat";
var myNumber; //variable declaration
myNumber = 42; //initializing myNumber variable

/* 
console is a JS browser object
log is a function/that will print the argument to the console

my console.log is taking a string argument with a value of cat
*/
console.log(cat); //passing a variable argument: cat
console.log("cat string"); //passing a string literal into the console
console.log(myNumber);
//abstracts the conversion of myNumber number to a string datatype TEMPORARY
console.log("My number is " + myNumber); //is concat 2 things to form 1 string
console.log(myNumber+18);

/*
Scope
during this line of execution, what can be seen e.g. variables
    global scope - declared outside of any function
    function scope - declared inside a function
*/

function foo(){

    /*
        cannot be seen through the console
        type: insideFoo
        in the console, it will not see the value and instead will see an error
        unlike when typing cat insside the console because cat is declared outside the fn
    */
    var insideFoo = "this string is inside the function foo";
    var anotherFooVar = "this is also a string inside of foo";
    var resultOfFoo = insideFoo + anotherFooVar;
    console.log("foo");

    return resultOfFoo;
}


/*
    create a function that takes 2 numbers a,b
        the arguments should be numbers, return the sum
*/

function sum(a,b){
    var result = a + b;
    return result;
}

function sub(a,b){
    var result = a - b;
    return result;
}