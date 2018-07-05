/* 1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/
function fibonacci(i, memo) {
    memo = memo || {};

    if (memo[i]) return memo[i];
    if(i <= 1) return 1;
  
    return memo[i] = fibonacci(i -1, memo) + fibonacci(i - 2, memo);
  }
  /*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
  */

 function palindrome(str) {
    // Step 1. The first part is the same as earlier
    var re = /[^A-Za-z0-9]/g; // or var re = /[\W_]/g;
    str = str.toLowerCase().replace(re, '');
   
    // Step 2. Create the FOR loop
    var len = str.length; // var len = "A man, a plan, a canal. Panama".length = 30
    
    for (var i = 0; i < len/2; i++) {
      if (str[i] !== str[len - 1 - i]) { // As long as the characters from each part match, the FOR loop will go on
          return false; // When the characters don't match anymore, false is returned and we exit the FOR loop
      }
    }
    return true; // Both parts are strictly equal, it returns true => The string is a palindrome
}
/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/

function reverseString(str) {
    var newString = "";
    for (var i = str.length - 1; i >= 0; i--) {
        newString += str[i];
    }
    return newString;
}