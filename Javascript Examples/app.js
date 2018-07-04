var cat = "cat"
var myNumber //Variable declaration
myNumber = 42 // Variable initialization
console.log(cat)
// Console is a Javascript browser object.
// Log will print the argument to the screen.
// cat is the argument
/* The plus operator + has many usess.
    1). Concatenation
*/
console.log("The number is " + myNumber) // Converts myNumber from number to string tempporarily.

/* Scope
    During this line of execution what can be seen.
    Golbal variables: Declared anywhere on the page but not in a function.
    Functional variables: Declaared inside a function and cannot be seen through the console.
*/
function foo() {
    var insideFoo = "This line is inside the function foo";
    var anotherfoo = "This linie is also inside the function foo.";
    var resultOfFoo = insideFoo + anotherfoo;
    console.log(resultOfFoo);
    return resultOfFoo;   //Give this variable to whoever called it. 
}
foo();
foo;







/*Create a function that takes two numbers A and b, 
that are numbers and rturn the sum.
*/
function sum (a,b) {
    console.log("The value of a " + a);
    console.log("The vallue of b " + b);
    var result = a + b;
    return result;
}
function subtract (x, y) {
    return x-y;
}
