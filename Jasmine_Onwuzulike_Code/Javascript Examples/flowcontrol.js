console.log("Flow Control JS File Loaded");

var myBoolean = true;

function foo () {
    if (myBoolean == true) {
        console.log("My boolean is true.");
        myBoolean = false;
    }
    else if (myBoolean == false) {
        console.log("My boolean is false");
        myBoolean = true;
    }
    else {
        console.log("My boolean is no longer true/galse.");
    }
}


function compareFour (a, b, c, d) {
    //compare a = b and c = d
    if (a == b && c == d) {
        console.log("a = b and c = d");
    }
    else if (a != b && c != d) {
        console.log("a doesn not = b and c does not = d");
    }
    else if (a == b || c == d) {
        console.log("a = b or c = d");
    }
}

function whichIsBigger(a,b ) {
    if (a > b) {
        return a;
    }
    else if (a < b) {
        return b;
    }
    else {
        return 100;
    }
}

var myArray = [
    "Bob",
    "Tom",
    "Bobber",
    "Mark"
];

//Loops
function printMyArray (arg) {
//For loop is the ost popular loop
for (i = 0; i  < 5; i +1) {
console.log( "i is " + i);
}

}







