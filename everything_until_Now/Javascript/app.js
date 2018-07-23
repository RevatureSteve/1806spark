var cat = "cat var";
var myNumber; // variable declaration
myNumber = 42; //initializing myNumbe variable to 42

/* console is a javascript browser object
log is a function/method that will
 print the argument to the console

 console.log(cat) cat is the argument 
 my console.log is taking a string argument
  with the value of "cat"
 */

console.log(cat); // passing a vaariable argument : cat
console.log("cat string"); //passing a string literal argument: cat string
console.log(myNumber);
// the + operator has many function aka uses
//abstract the conversion of myNumber number datatype to a string datatype
console.log("myNumber is " + myNumber); //abstract the conversion of myNumber datatype to a string datatype TEMPORARY
console.log(myNumber + 18); // + sign between two numbers datatype  will do regular addition.
var result = myNumber + 18;
console.log("my result is " + result) //another way of adding my number using a reult variable

/*
scope- during this line of 
excution what can be seen? e.g variables

global scope- decleared outside of any function
function scope- declered insode a function (cant be seen outside of it)
*/

function foo() {
    /*
    cannot be see through the console
    type:insideFoo  in the console and you will not see the values and instead see n error
    unline typing cat inside the console because cat is decleared out side of the function
     */
    var insideFoo = "this  string is inside the function foo"
    var anotherFoo = "this is a func.. inside foo"
    var resultOfFoo = insideFoo + anotherFoo;
    console.log(insideFoo + " " + anotherFoo);

    return resultOfFoo; // give the variable to whoever called it using the -
}

/* 
    create a function that take two arguments a,b 
    the arguments should be numbers
    return the sum
 */

 function sum(a, b) {
     // a, b are two parameter 'a is an argument and b is an argument'
     console.log("the value of a: " + a);
     console.log("the value of b: " + b);
     var result= a + b;
     return result;
 }

 function subtract(x, y) {
     return x-y; // same as sum but one line of code
 }
