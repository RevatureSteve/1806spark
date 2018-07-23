// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.


function fib(n) {
    let a = 1;
    let b = 0;
    let temp;

    while (n > 0) {
        temp = a;
        a = a + b;
        b = temp;
        n--
    }
    return b;
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.

let arrayTest = [7, 6, 9, 1, 8, 3, 5, 4, 2];

function bubbleSort(numArray) {
    let temp;
    swapFlag =false;
    for (let i = 0; i < numArray.length; i++) {
        for (let j = 1; j < numArray.length; j++) {
            if (numArray[j - 1] > numArray[j]) {
                swap = !swap; 
                temp = numArray[j - 1]; // takes the first item in arr and saves it to temp
                numArray[j - 1] = numArray[j];
                numArray[j] = temp;
            }
         
        }
        if(swapFlag != true){
            break;
        }
    }
    console.log(numArray);
}


// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.

function reverseStr(someStr) {
    return someStr.split("").reverse().join("");
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

function printShape(shape, height, character) {
    switch (shape.toLowerCase()) {
        case "triangle":
            for (var i = 0; i <= height; i++) {
                var row = "";
                for (var j = 0; j < i; j++) {
                    row += character;
                }
                console.log(row);
            }
            break;
        case "diamond":
            let arr = [];
            let half = Math.ceil(height / 2);
            for (var i = 0; i < height; i++) {
                arr.push(" ");
            };
            for (var j = 0; j < height; j++) {
                if (j < half) {
                    arr[half + j] = character;
                    arr[half - j] = character;
                }
                else {
                    arr[half + (height - j)] = " ";
                    arr[half - (height - j)] = " ";
                }
                console.log(arr.join(""));
            }
            break;
        case "square":
            for (let i = 0; i < height; i++) {
                let meep = "";
                for (let j = 0; j < height; j++) {
                    meep += character;
                }
                console.log(meep);
            }
    }
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false

function isPalindrome(someStr) {
    for (var i = 0; i < someStr.length / 2; i++) {
        if (someStr[i] !== someStr[someStr.length - 1 - i]) {
            return false;
        }
    }
    return true;
}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.

function factorial(someNum) {
    if (someNum == 0) {
        return 1
    }
    else {
        return (someNum * factorial(someNum - 1));
    }
}