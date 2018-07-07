var cat = "cat var";
var myNumber; //cariable declaration
myNumber = 42; //initializing myNumber variable

/* 
console is a javascript browser
log is a function/method that will 
    print the argument to the console

console.log(cat)::: cat is the argument
My console.log is taking a string argument
    with a value of "cat"
*/
console.log(cat); //pasing a variable argument
console.log("cat string"); // passing a string literal
console.log(myNumber);

// the + operator has many functions aka uses
//abstracts the conversikon of myNumber datatype to a string datatype TEMPORARY
console.log("My number is " + myNumber); //+ is concat 2 things to form 1 string
console.log(myNumber + 18); // + between 2 number datatypes will do regular addition


/* 
scope- during this line of execution what can be seen? e.g. variables
Glopal scope- declared outside of any funciton
function scope- declared inside of a function (can't be seen outside it)
*/

function foo(){
    /* cannot be seen through the console
    type:insideFoo in the console you will not see the value
    and insteade will see an error
    unlike typing cat inside the console because cat is declared outside the fn
    */
    var insideFoo = "this string is inside the function foo"; 
    var anotherFooVar= "this is also a string inside fn foo";
    var resultOfFoo= insideFoo + " " + anotherFooVar;
    console.log(resultOfFoo);
    
    return resultOfFoo; // give this variable to whoever called it using the = 
}




/*
    Create a function that takes 2 arguments a, b
        the arguments should be numbers
        return the sum
*/

function sum(a, b) {
    console.log("The value of a: " + a);
    console.log("The value of b: " + b);
    var result = a + b;
    return result;
}

function subtract (x, y){
    return x - y; //same as sum but in one line of code
}