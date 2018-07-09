/* 1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function fib(n) { 

    if (n <= 1) {
        
        return 1
    }
    else {

        return fib(n - 1) + fib(n - 2); //function calls itself
    }
}

/*2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/
var myArray = [5, 16, 3, 2, 53, 38, 56, 4, 8]
function bubbleSort(numArray) {

a = numArray.sort(function(a, b){return a-b});

console.log(a);
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