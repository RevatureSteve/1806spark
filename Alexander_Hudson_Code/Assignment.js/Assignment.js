// Fibonacci 

function fibonacci (n) { 
    //if the number is less than or equal to 1 than the number is returned to 1
    if(n<=1){ 
        return 1;
    }
    else {
        return (fibonacci (n-1) + fibonacci (n-2)); //adds the current and previous numbers together, returning the calculation e.g.(1,1,2,3,5,8,13,21,34,55,89,144)
    }
}

// Palindrome

function Palindrome(str) {

    // Step 1. Lowercase the string and use the RegExp to remove unwanted characters from it
    var re = /[\W_]/g;

    // str.toLowerCase() = "A man, a plan, a canal. Panama".toLowerCase() = "a man, a plan, a canal. panama"
    var lowRegStr = str.toLowerCase().replace(re, '');

    // Step 2. Use the same chaining methods with built-in functions from the previous article 'Three Ways to Reverse a String in JavaScript'
    var reverseStr = lowRegStr.split('').reverse().join('');

    // Step 3. Check if reverseStr is strictly equals to lowRegStr and return a Boolean
    return reverseStr === lowRegStr;
} 

// Reverse String 

function reverseString(str) {

    // Step 1: Create an empty string that will host the newcreated string
    var newString = "";

    // Step 2. Create the FOR loop
    /* The starting point of the loop will be (str.length - 1) which corresponds to the 
       last character of the string, "o"
       As long as i is greater than or equals 0, the loop will go on
       We decrement i after each iteration */
    for (var i = str.length - 1; i >= 0; i--) {
        newString += str[i];
    }
 
    // Step 3. Return the reversed string
    return newString;
}

//Delete Element

/*Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.*/


var list=["cheese", "cake", "fruit", "salsa"]; 
function deleteElement(arr, element){
 for (var i = 0; i<arr.length; i++)
{
    console.log(arr.length);
 if (element == arr[i])
{
    arr.splice (i, 1);
    console.log(arr.length);
    return true; // stop looking for the element, it was found
}
}
    return false; // stop looking for the element it was not found
}