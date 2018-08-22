<<<<<<< HEAD
var cat = "cat var";
var myNumber; //Variable Declaration
myNumber = 42; //initializing myNumber variable

/* 
console is a javascript browser objevt
log is a function /method that will print the
    argument to the console

console.log(cat) cat is the argument
My console.log is taking a string argument
    with a value of cat
*/
console.log(cat); //passing a variable argument:cat
console.log("cat string"); //passing a string literal argument "cat string"
console.log(myNumber);
 
//abstracts the conversion of myNumber data type to a String datatype TEMPORARY
// The + operator has many functions aka uses
console.log("the number is " + myNumber); //is concat 2 things to form 1 string
console.log(myNumber + 18) // + between 2 number datatypes will do regualr addition



/*
    Scope - during this line of execution 
        what can be seen? e.g. variables
    Global scope - declared outside of any function
    Function scope - declared inside of a function (can't be seen outside of it)

*/


function foo(){
    /*  cannot be seen through the console
        type: insideFoo
        in the console you will not see the value and instead will see an error 
        unlike typing cat inisde the console because car is declared outside the fn
    */
    
    var insideFoo = "this string is inside the function foo";
    var anotherFooVar = "this is also a string inside fn foo";
    var resultOfFoo = insideFoo +" " + anotherFooVar;
    console.log( resultOfFoo );

    return resultOfFoo; //give this variable to whoever called it using the =


=======
var cat ="cat var";
var myNumber; // Variable Declaration
myNumber = 42; // initializing myNumber variable

/*
    console is a javascript browser object 
    log is a function/method that will
        print the argument to the console

    console.log(cat) cat is the argument
    My console.log is taking a string argument
        with a value of "cat"
*/
console.log(cat); //passing a variable argument: cat
console.log("cat string"); //passing a string literal argument "cat string"
console.log(myNumber);

// The + operator has many functions aka users
// abstracts the conversion of myNumber number datatype to a string dayatype TEMPORARY
console.log("My number is " + myNumber); // + is concat 2 things to form 1 string
var result = myNumber + 18;
console.log(result); // + between 2 number datatypes will do regular addition


/*
    scope - during this line of execution
            what can be seen? e.g. variables
        Global scope - declared outside of any function
        Function scope - declared inside of a function (can't be seen ouside of it)

*/

function foo(){
    /*
        cannot be seen through the console
        type: insideFoo
        in the console you will not see the value and instead will see an error
        unlike typing cat inside the console because cat is declared outside the function
    */
    var insideFoo = "this string is inside the function foo"; 
    var anotherFooVar = "this is also a string inside the function foo";
    var resultOfFoo = insideFoo + " " + anotherFooVar; 
    console.log( insideFoo + " " + anotherFooVar);

    return resultOfFoo; // give this variable to whoever called it using the =
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
}




<<<<<<< HEAD
/* Create a function that takes 2 arguments a, b
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
    return x - y; //same as sum but in one line of code
=======

/*
    create a function that takes 2 arguments a, b
        the arguments should be numbers
        return the sum
*/
function sum(a, b) {
    console.log("The value of a: " + a);
    console.log("The value of b: " + b);

    var add = a + b;
    return add;
}

function subtract(x, y){
    return x - y; // same as sum but in one line of code
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
}