console.log("flow control js file loaded!");

var myBoolean = true;  //myBoolean is in the global scope, all functions can see this

function foo(){
if( myBoolean == true){
    console.log ("my boolean is true!");
    myBoolean = false;
}else if ( myBoolean == false) {
    console.log ("my boolean is false");
    myBoolean = true;
} else {
    console.log("myBoolean is no longer true/false");
}
}

function compareXandY (x, y){
    if( x == y){
        console.log ("x does = y");
    }else {
        console.log("x does not =y");
    }
}

function compareFour (a, b, c, d){
//  compare a == b, AND c ==f
if( a ==b && c==d){
    console.log("a=b and c=d");
}else if (a != b && c != d){
    console.log("a does not =b, c != d");
}else if (a == b  || c == d) {
    console.log("one of the 2 do = each other");
}
}

function whichIsBigger (a, b){
    if( a > b){
        return a;
    }else if (a < b) {
        return b;
    }else {
        return "=";
    }
}

// truthy/falsy

function isTrue(a){
    if(a){
        return true;
    }else {
        return false;
    }
}

var myArray = ["bob", "tom", "bobbert", "mark", "can't"];

// Loops
function printMyArray (arr){
    // the for loop is the most popular loop
    for( var i = 0; i < 5; i = i + 1){
        console.log(" myArray at index" + i + "is" + myArray [i]);
    }
}