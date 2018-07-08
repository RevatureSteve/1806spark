console.log("flow control js file loaded");

var myBoolean = true

function foo() {
if (myBoolean == true) {
    console.log("my boolean is true");
    myBoolean = false;
}
    else if (myBoolean == false) {
        console.log("my boolean is false");
        myBoolean=true;
    }
        else {
            console.log("my boolean is no longer true or false");
        }
}

function compareXandY(x,y){
    if(x == y){
        console.log("x does = y");
    }
    else {
        console.log("x doesn't equal y");
    }
}

function compareFour(a,b,c,d) {
    if (a==b && c==d){
        console.log("a=b and c=d");
    } else if (a != b && c!=d) {
        console.log("a does not equal b and c does not equal d");
    } else if (a == b || c==d) {
        console.log("one of the 2 do equal each other");
    }
}

function whichIsBigger(a,b){
    if( a > b) {
        return a
    }
    else if (a > b) {
        return b
    }
    else {
        return "=";
    }
}


/*
    Truthy/falsey
*/

function isTrue(a) {
    if(a){
        return true; //true,strings, positive numbers, negative numbers, objects
    }
    else {
        return false; //empty string, null, Nan, 0, undefined
    }
}


var myArray= ["bob","tom", "bobbert", "mark","can't"];
// get the length of array myArray.length

//loops
function printMyArray(arr) {
    // the for loop is the most popular loop

    for(var i=0; i < 5; i = i + 1){
        console.log("myArray at index " + i + " is: " + myArray[i]);
    }
}

