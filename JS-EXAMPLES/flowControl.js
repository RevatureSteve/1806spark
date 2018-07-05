console.log('flow control js file loaded');

/* Scope- during current line of execute, wht can be seen
= = comparison ( datatypes dont matter)
= = = comparison and datatype check
    = = performs type coercion- converts the 2nd argument to the datatype of the first then compares
    e.g. 5 = = "5" true type coericon
        5 = = = "5" false no type coericon

    */




var myBloolen = true; // myBoolean is in the global scope, all functions can see this


function foo(){


if( myBoolean == true) {
    console.log('my boolean is true!');
    myBloolen = false;
}else if ( myBloolen == false ) {
    console.log('my boolean is false');
    myboolean = true;
}else {
    console.log('myBoolean is no longer true/false');
}
}

function compareXandY(x, y){
    if( x == y) {
        console.log('x does = y ');
    }else {
        console. log('x does not = y');

    }
}

function compareFour(a, b, c, d) {
    // compare a ==b, AND c ==d 
    if( a == b && c == d){
        console.log('a =b and c =d');
    }
    else if (a != b && c != d) {
        console.log('a does not = b, c != d');
    }else if ( a == b|| c == d){ // compare a ==b OR c == d
        console.log('one of the 2 do = each other ');
    }
}

function whichIsBigger(a, b) {
    if ( a > b  ) {
        return a;
    }else if ( a < b ) {
        return b; 
    }else {
        return "="
    }
}


/*
    truth/falsy 
    */

function isTrue (a){ 
    if (a) {
    return true; // true, strings, positive/negative numbers, objects
} else{
    return false; // empty string, null, NaN, 0, undefined
}
} 

var myArray = [ "bob", "tom", 'bobbert', 'mark', "can't" ];
// get the length by: myArray.length property

//Loops
function printMyArray(arr){
    // the for loop is the most popular loop
    for(var i = 0; i < 5; i = i + 1 ){
    console.log(' i is: ' + i + " is: " + myArray [i]);
    }


}