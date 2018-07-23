/*1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence. */

function fib(n){
  if (n <= 2) return 1;

  const f = [0, 1, 1,2,3,5,8,13];
  for( let i = 3; i <= n; i++ ){
    f[i] = f[i - 1] + f[i -2];
  }
  return f[f.length - 1];
}

//^^ I don't understand what this is doing//

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

//doing #4 a different way

function factorial2(someNum) {
  if (someNum != 1 ) {
    var result = someNum * factorial2(someNum - 1);
    return result;
  }else {
    return 1;
  }
  }


// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.

function substring(someStr, length, offset) {
  var stringArray = someStr.split("");
  var subArray = [];
  for (var i = 0; i < length; i++) {
    subArray[i] = stringArray[i + offset];
  }
  return subArray.join("")
}


// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.

function isEven(someNum) {
  while (someNum / 2 > 1) {
    someNum = someNum / 2;
  }
  if (someNum == 2) {
    return true;
  } else {
    return false;
  }
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false

function isPalindrome(someStr) {
  var reversed = reverseString(someStr);
  if (someStr == reversed) {
    return true;
  } else {
    return false;
  }
}

// 8. Shapes
// Define function: printShape(shape, height, character)
// shape is a String and is either "Square", "Triangle", "Diamond".
// height is a Number and is the height of the shape. Assume the number is odd.
// character is a String that represents the contents of the shape. Assume this String contains just one character.
// Use a switch statement to determine which shape was passed in.
// Use the console.log function to print the desired shape.
// Example for printShape("Square", 3, "%");
// %%%
// %%%
// %%%
// Example for printShape("Triangle", 3, "$");
// $
// $$
// $$$
// Example for printShape("Diamond", 5, "*");
//   *
//  ***
// *****
//  ***
//   *

// function printShape(shape, height, character) {

//   switch (shape){
//     case "Square": {
//       for (var i = 0; i < height; i++) {
//         var shapeStr = "";
//         var shapeStr = shapeStr + character;
//       }
//       console.log(shapeStr);
//     }
//     break;
  
//    case "Triangle": {
//       for (var i = 0; i < height; i++) {
//         var shapeStr = "";
//       }
//       for (var j = 0; j < i + 1; j++) {
//         shapeStr = shapeStr + character;
//       }
//       console.log(shapeStr);
//     }
//     break;
  
//     case "diamond": {
//       var space = height/2;
//       for (var i = 0; i < height / 2; i++) {
//         var shapeStr = "";
//       }
//       space--;
//       for(j = 1; j <=2 * i - 1; j++){
//         shapeStr = shapeStr + character;
//       }
//       console.log(shapeStr);
//     }
//     for (i = 0; i <= height / 2; i++) {
//       var shapeStr = " ";
//     }
//     space++;
//     for (j = 0; j <= ((height - i*2)-1);j++) {
//       shapeStr = shapeStr + character;
//     }
//     console.log(shapeStr);
//   }
//     break;
   
// }default: {

  


// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.

function traverseObject(someObj) {
  var keys = Object.keys(someObj);
  var values = Object.values(someObj);

  for(var i = 0; i < keys.length; i++){
    console.log("Key value: "+keys[i]+", value: "+ values[i]);
  }
  return values;
}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);























 