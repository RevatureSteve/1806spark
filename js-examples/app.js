var cat = "cat var";
var number; //variabel declaration
myNumber = 42; //initializing myNumber
/*console is a javascript browser object
log is a func/method that will
    print the arguement to the console

console.log(cat) cat is the arguement
my console.log is taking a string arguement
    with a value of "cat"
*/

console.log(cat); //passing a variable arguement: cat
console.log("cat string"); //passing a string literal arguement "cat string"
console.log(myNumber);

console.log(5); //passing a string literal arguement "cat string"
console.log("My number is " + myNumber); //concatinating myNumber to the string using the "+"
console.log(myNumber + 18); //"+"" between 2 number datatypes will do regular addition

/*
    scope - during this line of execution 
        what can be seen? e.g. variables
    global scope - declared outside of any function
    function scope - declared inside of a function
        (can't be seen outside of it)
*/
function foo() {
    /* 
        cannot be seen through the console
        type: inside foo
        in the console you will not see the value and 
            instead will see an error unilke typing cat 
            inside the console because cat is declared 
            outside the func
    */
    var insideFoo = "this string is inside the func foo";
    var anotherFooVar = "this is also a string inside func foo";
     var resultOfFoo = insideFoo + "" + anotherFooVar;
    console.log ( resultOfFoo );

    return resultOfFoo; //give this variable to whoever called it using the =
}

/* create a func that takes 2 arguements a, b
    the arguements should be numbers
    return the sum
*/
function sum(a, b) {
    console.log("the value of a: " + a);
    console.log("the value of b: " + b); 
    var result = a + b;
    return result;
}

function subtract(x, y){
    return x - y; //same as sum but in one line
}