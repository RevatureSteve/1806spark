var cat = "cat var";
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
console.log(cat); // passing a variable argument: cat
console.log("cat string"); // passing a string literal argument "cat string"
console.log(myNumber);

// The + operator has many functions aka uses
//abstracts the conversion of myNumber number datatype to a String datatype TEMPORARY
console.log("My number is " + myNumber); // + is concat 2 things to form 1 string
var result = myNumber + 18;
console.log( result); // + between 2 number datatypes will do regular addition
