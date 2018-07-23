console.log('flow control js file loaded');

var myBoolean = true;

function foo() {
    if (myBoolean == true) {
        console.log('my boolean is true');
        myBoolean = false;
    }
    else if (myBoolean == false); {
        console.log('myboolean is false');
        myBoolean = true;
    }
    // else {
    // console.log('myBoolean is no longer true/false');
    // }
    /*== comparison operator
===perform type coercion – convert the 2nd argument to 
the datatypes of the first one compares them
 e.g 5== “5” true type coercion
 */
}

function compareXandY(x, y) {
    if (x == y) {
        console.log('x does equal y')
    }
    else {
        console.log('x does not == y')
    }
}

function compareFour(a, b, c, d) {
    //compares a==b, AND a==d]


    if (a == b && c == d) {
        console.log('a=b and c=d')
    }


    else if (a != b && c != d) {
        console.log('a does not =b, c!=d')
    }
    else if (a == n || c == d) {
        // compares ba== and c==d
        console.log("one of the two do = the other")

    }
}

/////////////////
function whichIsBigger (a, b) {
    if (a> b) {
        console.log()
    }
}

/*true or false */
function isTrue(a) {
    if(a)
    {
        return true; //true, string, postitive/ negative numbers, objects
    }
        else {
            return false; //"" empty strings, nul, nan, 0
        }
}



var myArray = ["bob","tom","bobbert","mark"];
// get the length of the array you do myArray.length and it will output the right length


// loop
function printMyArray(arr) {
    // the for loop is the most popular loop
    // initial; condition; then iteraction
    for (var i=0; i<5; i= i+1);
     console.log("i is : " + i);
}
function printMyArray(arr) {
    // the for loop is the most popular loop
    // initial; condition; then iteraction
    for (var myArray=0; myArray<5; myArray++);
     console.log("the value of myArray is : " + myArray+ myArray[myArray]);
}