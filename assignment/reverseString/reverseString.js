// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.

function reverseStr(someStr){
    var newString = "";
    for (var i = someStr.length - 1; i >= 0; i--) {
        newString += someStr[i];
    }
    return newString;
}
