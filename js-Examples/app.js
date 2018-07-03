var cat = "cat";
var myNumber;
myNumber = 42;

/*console is a javascript browser object 
log is a function/method that will
    print the argument to the console
    console.log(cat) cat is the argument
    with a value of cat
    */

console.log(cat); //passing a variable argument
console.log("cat string"); //passing a string literal
console.log(myNumber);//abstracts the conversion of myNumber number datatype to a String datatype TEMPORRYARY 
//The + operator has many functions aka uses
console.log("My number is " + myNumber); // + is concat 2 things to form 1 string
console.log(myNumber + 18); //+ brterrm 2 number datatypes will do regular addition

/* Scope - during this line of execution 
            what can be seen? e.g. variables
            Global scope - declared outside of any function
            Funciton scope - declared inside of a function (can't be seen outside of it)
*/
function foo() {
    /*cannot be seen through the console
    type: insideFoo
    in the console you will not see the value and instead will see an error
    unlike typing cat inside the console because cat is declared outside the fn*/

    var insideFoo = "this string is inside the function foo";
    var anotherFooVar = "this is also a string inside of the function foo";
    var resultOfFoo = insideFoo + "" + anotherFooVar;
    console.log("foo");

    console.log(resultOfFoo);

    return resultOfFoo;
}


/*Create a function that takes 2 arguments a, b
    the arguments should be number
    return the sum*/

function sum(a, b){
    console.log("The value of a: " + a);
    console.log("The value of a: " + b);

    var result = a + b;
    return result;
}

function subtract(x, y){
    return x - y;
}