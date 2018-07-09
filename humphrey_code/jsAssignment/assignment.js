/* 1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function fib(n) { 

    
}



/* 3. Reverse String
Define function: reverseStr(someSt)
Reverse and return the String.
*/

function reverseStr(someSt) {

  var x = someSt.split(""); //splits string into an array of substrings

  var y = x.reverse(); //reverses the array

  var z = y.join(""); //joins the reversed array

  return z;

}



/* 5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/




/* 6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/

function isEven(someNum) {

 var b = someNum.toString();

 if (b.charAt(b.length-1) == "0" || b.charAt(b.length-1) == "2" 
 || b.charAt(b.length-1) == "4" || b.charAt(b.length-1) == "6" 
 || b.charAt(b.length-1) == "8") { 
    console.log(someNum + " is an Even Number")
 }

 else {
    console.log(someNum + " is an odd number")
 }
}


/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/



/* 11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/
var myArr=[0,1,3,6,6];
function spliceElement(someArr) {

    console.log("Length of array is: " + someArr.length);
    someArr.splice(2,1);
    console.log("New length of array is: " + someArr.length);


}

/* Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false */


function isPalindrome(someStr) {

  var x = someStr.split(""); //splits string into an array of substrings

  var y = x.reverse(); //reverses the array

  var z = y.join(""); //joins the reversed array

  if (z==someStr) {
      return true
  }
  else {
        return false 
  }


}