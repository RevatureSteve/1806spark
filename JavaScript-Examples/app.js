var cat = "cat var";
var myNumber;
myNumber = 42;
/* console is a javascript browser object
log is a function/method that will print the 
argument to the console 

console.log(cat) cat is the argument
My console.log is taking a string argument
with a value of "cat" */
console.log(cat); //passing a variable argument cat
console.log("cat string"); // passing a string literal argument "cat string"
console.log(myNumber);
console.log("My number is " + myNumber); // using the + to concat 2 thing to form 1 string
//abstracts the conversion of myNumber number datatype to a string datatype TEMPORARY 
console.log(myNumber + 18);// + between 2 number datatypes will do regular addition

/*
   Scope - during this line of execution
   what can be seen?
   e.g. variables
   Global scope - declared outside of any function
   Function scope - declared inside of a function(can't be seen outside of it)
*/

function foo(){
    /*cannot be seen through the console
    type:insideFoo
    in the console you will not see the value and instead you will see an error
    unlike typing cat inside the console because cat is declared outside the fn(function)
    */
    var insideFoo=" this string is inside foo function"; 
    var resultoffoo=cat + insideFoo;
    console.log(cat);

    return resultoffoo; //give this variable to whoever called it using the =
}



/* 
Create a function that take 2 arguments a, b 
the arguments should be numbers
return the sum
*/
function sum(a, b){
    console.log("The value of a: " + a);
    console.log("The value of b: " + b);
    var result = a + b;
    return result;
}

function subtract(x,y){
    return x - y;
}
