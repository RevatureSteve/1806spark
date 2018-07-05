console.log('flow control js file is loaded!');

var myBoolean = true;

function foo() {

    if (myBoolean == true) {
        console.log('my bool is ' + myBoolean)
        myBoolean = false;
    } else if (myBoolean == false) {
        console.log('my bool is ' + myBoolean)
        myBoolean = true;
    } else {
        console.log('my bool is no longer true/false');
    }
}

/*  == compairision 
 === compairsion and datatype check
*/

function compareXandY(x, y) {
    if (x == y) {
        console.log('x == y');
    }
    else {
        console.log('x != y');
    }
}
function conpareFour(a, b, c, d){
    // care a == b, AND c == d
    if (a == b && c == d)
    {
        console.log('a = b and c = d')
    }else if (a != b && c != d)
    {
        console.log('a != b && c 1= d ');
    }
}
/*
    truthy/falsy
*/
function isTrue(a){
    if(a){
        return true; // true, strings, positive and negative negative, Infinity, objects
    }else{
        return false;// empty string("  "), null, NaN, 0, false, undefined
    }
}

var myArray = ['bob', 'tom', 'bobbert', 'mark'];
//  get the lenght by: myArray.length

// Loops
function printMyArray(){
    // the for loop is the most popular loop
    //  init;    condition;   after each iteration
    for(var i = 0; i < 5; i = i ++)
    {
        console.log("The value of myArray at index  " + i + " is: " + myArray[i]);
    }
}