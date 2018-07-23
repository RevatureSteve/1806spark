console.log('flow control js file loaded!');

// flow control

var myBoolean = true;

function foo() {
    if (myBoolean == true) {
        console.log('my boolean is true!');
        myBoolean = false;
    }
    else if (myBoolean == false) {
        console.log('my boolean is false!');
        myBoolean = true;
    }
    else {
        console.log('stop messing with my boolean!');
    }
}

function compareXandY(x, y) {
    if ( x == y) {
        console.log('x does = y');
    }
    else {
        console.log('x does not = y');
    }
}

function compareFour(a, b, c, d) {
    // compare a == b, AND c == d
    if (a==b && c==d) {
        console.log('a = b and c = d');
    }
    else if (a != b && c != d) {
        console.log(' a does not = b and c does not = d');
    }
    else if (a == b || c == d) {
        console.log(" one of the 2 do = each other ");
    }
}

function whichIsBigger(a,b) {
    if (a > b) {
        return a;
    }
    else if (a < b) {
        return b;
    }
    else {
        return "equal";
    }
}

// truthy/falsy

function isTrue (a) {
    if(a) {
        return true;
    }
    else {
        return false;
    }
}

var myArray = ['bob', 'tom', 'bobbert', 'mark'];

//  loops

function printMyArray(arr) {
    // for loop
    for(var i = 0; i < myArray.length; i++) {
        console.log("The value of myArray at index " + i + " is: " + myArray[i]);
    }
}