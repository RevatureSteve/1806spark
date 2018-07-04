// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.

function fib(n) {
    let a = 1;
    let b = 0;
    let temp;

    while (n >= 0) {
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




// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.

// function reverseStr(someStr) {

//     var stringArr = someStr.split("");
//     var reverseStr = stringArr.reverse();
//     var newStr = reverseStr.join("");

//     return newStr;

// }

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
    switch(shape.toLowerCase()) {
        case "triangle":
        for (var i = 0; i <= height; i++) {
            var row = ""
            for (var j = 0; j < i; j++) {
                row += character;
            }
            console.log(row);
        }
        break;
        case "diamond":
        for (var i = 0; i <= height; i++) {
            var row = ""
            for (var j = 0; j < i; j++) {
                row += character;
            }
            console.log(row);
        }
        break;
        // for (var i = 0; i <= height; i++) {
        //     var row = ""
        //     for (var j = 0; j < i; j++) {
        //         row += character;
        //     }
        //     console.log(row);
        // }
    }
}