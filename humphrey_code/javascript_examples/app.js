var cat = "cat war";
var myNumber = 42; //variable declaration and initialization

/* log is a function/method that will 
print the argument to the console */

// cat is the argument
// My console.log is taking a string arguement with a value of cat
console.log(cat); //passing a variable argument
console.log("cat string"); //passing a string literal arguement "cat string"
console.log(5); //passing a number literal arguement "cat string"
console.log(myNumber);
console.log("My number is " + myNumber); //abstract the conversion of myNumber datatype to a String datatype TEMPORARIRY

// the + operator has many functions aka uses

console.log(myNumber + 18); // add 18 to the variable temporarily (to number datatypes)

//scope = during this line of execution, what can I see
function foo (){
    var insideFoo= "this string is inside the function foo"; //cannot be seen through the console
    var anotherInside= "this is another string inside of foo";
    resultOfFoo = insideFoo + " " + anotherInside;
    console.log(insideFoo);

    return resultOfFoo; //Give this variable to who ever called it
}
