var cat = "cat var";
var myNumber; //variable declaration
myNumber = 42; //initializing myNumber variable

/*
console is a javascript browser object log is a fuction/method that will print the arguement to the console

console.log(cat) cat is the arguement 
My console.log is taking a string arguement with a value of "cat"

*/
console.log(cat); //passing a variable arguement :cat
console.log("cat string"); //passing a string literal arguement "cat string"
console.log(myNumber);
//abstarct the conversion of myNumber number datatype to a String datatype TEMPORARY
//The + operator  has many functions aka class
console.log("The number is " + myNumber);  // + is concat 2 things to form 1 string
console.log(myNumber + 18);//+ between 2 number datatypes will do regular addition
console.log(result);

// Scope - during this line of execution what can be seen? e.g. variables
// Global scope - defined outside of any function
// Function scope - declared inside of a function (can't be seen outside of it)

function foo(){
    /*
    cannot be seen through the console
    type: insideFoo
    in the console you will not see the value and instead will see an error
    unlike typing cat inside the console because cat is declared outside the fn
    */
    var insideFoo = "this string is inside the function foo"
    var anotherFooVar = "this is also a string inside fn foo"
    var resultOfFoo = insideFoo + "" + anotherFooVar;

    console.log(insideFoo);
    return resultOfFoo;



}
/*
Create a function that takes 2 arguments a, b the arguments should be numbers return the sum
*/

function sum(a, b) {
    console.log("The value of a: " + a);
    console.log("The value of b: " + b);

    var result = a + b;
    return result;

}

function subtract(x,y){
    return x - y; // same as sum but in one line of code
}

