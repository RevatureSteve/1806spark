var cat = "cat var";
var myNumber;
// /variable decalration
myNumber = 43; 
// initializing myNumber cariable i.e. giving it a value

// console is a javascript browser object used for debugging code not in production
// log is a function/method that will print the argument to the console
/*console.log(cat) cat is the argument
my console.log is taking a string argument
with a value of "cat"
"cat string" is a literal string

*/
console.log(cat); 
// passing a variable argument: cat
console.log("cat string");
// passing a string literal argument "Cat string"
console.log(myNumber);
console.log("My number is " + myNumber);
// abstracts the conversion of myNumnber number datatype to a string datatype TEMPORARY
//  the + operator has many functions and uses, such as to concat 2 things to form 1 string
console.log(myNumber + 18 );
// + between 2 number datatypes will do regular addition
// you could subsitute myNumber+18 with var result = myNumber+18 and then put result into console.log(result)