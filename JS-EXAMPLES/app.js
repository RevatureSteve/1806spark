var cat = "cat"
var myNumber;//Variable Decaration 
myNumber= 42; // initializing myNumber variable 

/*
 console is a javascript brwower object
log is a functuin/method that will
print the arugment to the console

console.log(cat)  cat is the argument
My console.log is taking a string argument
    with a value of "cat"
*/
console.log(cat); // passing a variable argument: cat 
console.log("cat string"); // passing a string literal argument "cat string" 
console.log(myNumber) 

// The + operator has many functions aka uses
 // abstracts the conversion of myNumber number datatype to a string datatype TEMPORARY
 
console.log("My number is " + myNumber); //+ is concat 2 things to form 1 string
console.log(myNumber + 18); // between 2 number datatypes will do regular addition
console.log (result); // + between 2 number datatypes will do regular addition

/* Scope;during this line of execution what can be seen?  e.g. variables
Global scope-declared outside of any function
Function scope- declared inside of a function ( can't be seen outside of it)

*/

function foo(){
    /* cannot be seen through the concole
    type: insidefoo
    In the console you will not see the value and instaeand will see an error unlike typring cat inside the console because cat is declared outside the function*/
    var insidefoo ="this string is inside the function foo"
    var anotherFooVar = "this is also a string inside function foo"
    var resultOfFoo = insideFoo + anotherFooVar
    console.log (resultOfFoo);
    
    return resultOfFoo;// give this variable to whoever called it 


}

    /* 
    Create a function that takes 2 arguments a, b
    the arguments should be numbers
    return the sum 
    */

    function sum (a, b) {
        console.log("The value of a: " +a);
        console.log("The value of b: " + b)

        var result = a +b;
        return result; 
    }
    function substract(x, y){
        return x - y; // same as sum but in one line of code
    }