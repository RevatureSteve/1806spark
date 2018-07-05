console.log('Daniels Part 3 has loaded');

/*
    Define function: reverseStr(someStr)
    Reverse and return the String.
*/

var someStr = ''; //just so you can punch in any string you like to be reversed

function reverseStr(someStr){
    var newStr = ''; //used to store the new string

    for(var i = someStr.length - 1; i >= 0; i--){
        newStr = newStr + someStr[i]; 
        /*
         the above eq. grabs the last string and prints that letter 
        and moves down 1 after each iteration
        */
    }
    console.log('The reverse string of "' + someStr + '" is "' + newStr + '"');
}