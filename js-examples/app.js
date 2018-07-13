var cat = "cat";
var myNumber; //variable declaration
myNumber = 42; //initializing myNumber variable
/*
    console is a javaScript browser object
    log is a function/method that will
    print the argument to the console

    console.log(cat) cat is the argument
    My console.log is taking a string argument
        with a value of "cat"

    */
console.log(cat); //passing a variable argument: cat
console.log("cat string"); // passing a string literal argument "cat string"
console.log(myNumber); 
console.log("My number is " + myNumber); //+ is concat 2 things to form 1 string
//abstracts the conversion of myNumber number data type to a string data type
//the "+" operator has many functions
console.log(myNumber + 18);// + between two number data types will do regular addition

// scope- during this line of execution what can be seen? variables
// global scope- declared outside of any function
// function scope- declared inside of a function, can't be seen outside of it

function foo(){

    // cannot be seen through the console
    // type: insideFoo
    // in the console, you will not see a value and will instead see an error
    // unlike typing cat inside the console because cat is declared outside the fn

    var insideFoo = "this string is inside the function foo";
    var anotherFooVar = " this is also a string inside the function foo";
    var resultOfFoo = insideFoo + " " + anotherFooVar;
    console.log(resultOfFoo);

    return resultOfFoo;  //give htis variable to whoever called it using the assignment operator (=)
}












/* create a function that takes two arguments a,b
    the arguments should be numbers
    return the sum
    */
function sum(a, b) {
    console.log("the value of a: " + a);
    console.log("the value of b: " + b);
    var result = a + b;
    return result;
}

function subtract (x, y) {
        return x - y;  //same as sum but in one line of code
}