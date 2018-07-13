var cat = "cat var";

var myNumber; //variable declaration
myNumber = 42;

/*
console is a javascript browser object
log is a function/method that will print
    the argument to the console.

console.log(cat) is the argument
My console.log is taking a string argument.
    with a value of "cat"

*/

console.log(cat); //passing a variable argument: cat
console.log("cat string"); //passing a string literal
console.log("My Number is " + myNumber); // + is concat 2 things to form 1 string.
//abstracts the conversion of myNumber number datatype to a String datatype for this case.
// The + operator has many functions / uses.

console.log(myNumber+18); //+ between 2 number datatypes.

//animation in key frames.

//reserved words do not have functionality, but, may at some point in the future.
//keywords have functionality.

// string has "quotations around it". an "" (empty string)

//array is a group of elements

// var myArray=["bob", "bobby". "billy"


function foo(){

    /*
Scope - during this line of execution, what can be seen? eg: variables
- Global Scope: Declared outside of any function
- Function Scope - Declared inside of a function (cant be seen outside of it)

*/
    var insideFoo = "This string is inside the function foo" ;
    var anotherone = "another string";
    var resultsfoo = "insideFoo + anotherone";
    console.log(insideFoo + " + " + anotherone);

    return resultsfoo; //gives this variable to whoever called it using the =
}



/* 

    Create a function that takes 2 arguments a, b
    the arguments should be numbers
    returns the sum

*/

function sum(a, b){
console.log(a);
console.log("+")
console.log(+b);
console.log("=");

var result = a+b;
//OR
return a+b;
return result;

}

function subtract(a,b){
    console.log(a);
    console.log("-");
    console.log(b);
    console.log("=");

    return a-b;
}
