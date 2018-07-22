console.log('flow control js loaded!');

/*
    scope - during this line of execution, eht can be seen?

    == caparisons (datatypes don't matter)
    === comparison and datatype check

        preforms type coercion - converts the 2rd arguement to
        the datatype of the first the compares

        e.g. 5 == 5 true type coercion

*/
var myBoolean = true; // myBoolean is in the global scope. all functions can see this

function foo() {
    if(myBoolean == true){
        console.log('my boolean is true');
        myBoolean = false;
    } else if(myBoolean == false){
        console.log('my boolean is false');
        myBoolean = true;
    } else{
        console.log('my boolean is no longer true/false');
    }
}

function compareXandY(x, y){
    if(x == y){
        console.log('X is equal to Y');
    } else{
        console.log('X does not equal to Y');
    }
}

function compareFour(a, b, c, d){
    // compare a==b, AND c==d
    if(a == b && c == d){
        console.log('a = b and c= d');
    } else if(a != b && c != d){
        console.log('a does not equal b and c does not equal d');
    } else if(a == b || c == d){
        console.log('one of the two do equal each other');
    }
}

function whichIsBigger(a, b){
    if(a > b) {
        return a;
    } else if (a < b){
        return b;
    } else {
        return "=";
    }
}

/*
    truthy/falsy
*/
function isTrue(a){
    if(a){
        return true; //true, strings, postive/negative numbers, objects
    } else{
        return false; // false, "" - empty strings, null, NaN, 0, undefined
    }    
}

var myArray = ['bob', 'tom', 'bobbert', 'mark'];
// get the array length by typing: myArray.length
// get a single element within an array by typing: myArray[1] prints: "bob"

// Loops 
function printMyArray(arr){
    //the "for" loop is the most popular loop
    // initial; condition; after each iteration
    for(var i = 0; i < 5; i = i + 1)
        console.log('the value for myArray at index is: ' + i + " is: " + myArray[i]);
}