// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
function fib(n) {
var fibonacci  = [1,3,4,6,8,2,8,];
var num = fibonacci[n];
return num;
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(numArray) {
    var numArray = ["zoo", "apple", "carrots"];
    return numArray.sort();
}
// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseStr(someStr) {
     var firstStr = " ";
     for (var i = someStr.length - 1 ; i >= 0; i--){
        firstStr += someStr[i];
     }
     return firstStr;
}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
    var numArray = [];
    for (var i = someNum; i >= 0; i--) {
    numArray.push(i);
    }
    return numArray;
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traverseObject(someObj) {
    console.log(someObj);
}


