var cat = "cat var";
var myNumber; //Variable Decleration
myNumber = 42; //Initializing myNumber variable
/* 
    console is a javascript browser object
    log is a function/method that will
        print the argument to the console

    console.log(cat) cat is the argument
    My console.log is taking a string argument
        with a value of "cat"
*/
console.log(cat); //passing a variable argument: cat
console.log("cat string"); // passing a string literal argument "cat string"
console.log(myNumber);
// The + operator has many functions aka uses
//abstracts the conversion of myNumber number datatype to a String datatype TEMPORARY
console.log("The number is " + myNumber); //+ is concat 2 things to form 1 string
console.log(myNumber + 18); //+ between 2 number datatypes will do regular addition
var result = myNumber + 18;
console.log(result);

/*
Scope - during this line of execution
        what can be seen? e.g. variables?
    Global scope - defined outside of any function
    Function scope - declared inside of the function (can't be seen outside of it)
*/

function foo(){
    /* cannot be seen throught the console
    type: insideFood
    in the console you will not see the value and instead wil see an error
    unlike typing cat inside the console because cat is dclared outside the function
    */
   
   var insideFoo = "this string is inside the function foo"; 
   var anotherFooVar = "this is also a string inside the fn foo"; 
   var resultOfFoo = insideFoo + " " + anotherFooVar;
   console.log( resultOfFoo );
   
   return resultOfFoo; //give this variable to whoever called it using the =
}

/*
Creat a function that takes 2 arguments a, b
    the arguments should be numbers
    return the sum
*/

function sum(a,b){
console.log("The value of a: " + a);
console.log("The value of b: " + b);
var result = a + b;
return result;
}

function subtract(x,y){
return x - y; //same as sum but in one line of code
}

