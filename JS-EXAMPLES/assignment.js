/*1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence. */

function fib(n){
 if (n <= 2) return 1;

 const f = [0, 1, 1];
 for( let i = 3; i <=n; i++){
 f[i] = f[i - 1] + f[i -2];
 }
 return f[f.length - 1];
}



function fib2(n){
 var a = 0;
 var b = 1;
 var sum = 0;
 for (var i = 0; i < n; i++) {
 sum = a + b;
 a = b;
 b = sum;
 }
 return sum;

}

// /*2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array. */

//Bubble sort is a simple sorting algorithm that repeatedly steps 
//through the list to be sorted, compares each pair of adjacent 
//items and swaps them if they are in the wrong order. 
//The pass through the list is repeated until no swaps are needed,
// which indicates that the list is sorted.

function swap(numArray, i, j){
 var temp = numArray [i];
 numArray[i] = numArray [j];
 numArray[j] = temp;
}

var n = [9, 2, 5, 6, 4, 3, 7, 10, 1, 8];
function bubblesort(numArray){
 
 var swapped;
 do{
 swapped = false;
 for(var i = 0; i < numArray.length; i++){
 if(numArray[i] && numArray [i + 1] && numArray[i] > numArray [i + 1]){
 swap(numArray, i, i + 1);
 swapped = true;
 }
 }
 }while(swapped);
 return numArray;
}

// /*3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
// */


function reverseString(str) {
 // Step 1. Use the split() method to return a new array
 var splitString = str.split(""); // var splitString = "hello".split("");
 // ["h", "e", "l", "l", "o"]
 
 // Step 2. Use the reverse() method to reverse the new created array
 var reverseArray = splitString.reverse(); // var reverseArray = ["h", "e", "l", "l", "o"].reverse();
 // ["o", "l", "l", "e", "h"]
 
 // Step 3. Use the join() method to join all elements of the array into a string
 var joinArray = reverseArray.join(""); // var joinArray = ["o", "l", "l", "e", "h"].join("");
 // "olleh"
 
 //Step 4. Return the reversed string
 return joinArray; // "olleh"
}


// /*4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum. */
//taking a big problem and sub-dividing it into multiple,
//Put into practice, that generally means writing a function that calls itself. 


// smaller instances of the same problem.

function factorial(x) 
{ 

 if (x === 0)
 {
 return 1;
 }
 return x * factorial(x-1);
 
}
console.log(factorial(5));