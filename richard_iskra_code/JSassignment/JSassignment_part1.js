//Part I

/*
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function fib(n) {
    if (n >= 1) {  //first element
        console.log(0);
    }
    if (n >= 2) {  //second element
        console.log(1);
    }
    if (n >= 3) {  //all other elements
        var a = 0;
        var b = 1;
        for (var i = 2; i < n; i++) {
            if (a < b) {
                console.log(a + b);
                a = a + b;
            } else {
                console.log(a + b);
                b = a + b;
            }
        }
    }
}

/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/

var numArray = [6, 2, 5, 9, 8, 4, 4, 2, 3, 6, 8, 7, 1, 5, 5, 2];

function bubbleSort(numArray) {
    for (var i = 0; i < numArray.length; i++) {
        for (var j = 1; j < numArray.length; j++) {
            if (numArray[j - 1] > numArray[j]) {
                swap(numArray, j - 1, j);
            }
        }
    }
    console.log(numArray);
}

function swap(numArray, i, j) {
    var temp = numArray[i];
    numArray[i] = numArray[j];
    numArray[j] = temp;
}

/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/

function isEven(num) {
    if (num % 2 == 1) {
        return false;
    } else if (num % 2 == 0) {  //no remainder = divisible by 2
        return true;
    } else {
        window.open("https://www.youtube.com/watch?v=cMTAUr3Nm6I&t=31s", '_blank'); //why not
    }
}

/*
8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
Example for printShape("Square", 3, "%");
%%%
%%%
%%%
Example for printShape("Triangle", 3, "$");
$
$$
$$$
Example for printShape("Diamond", 5, "*");
  *
 ***
*****
 ***
  *
*/

function shapes(shape, height, symbol) {
    var str = "";
    switch (shape) {
        case "square":                                  //suqare
            for (var i = 0; i < height; i++) { //loop for rows
                for (var j = 0; j < height; j++) { //loop for string contents
                    str += symbol;
                }
                console.log(str);
                str = "";   //reset string for next row
            }
            break;

        case "triangle":                                //triangle
            for (var i = 0; i < height; i++) {
                for (var j = 0; j < i + 1; j++) {
                    str += symbol;
                }
                console.log(str);
                str = "";
            }
            break;

        case "diamond":                                 //diamond
            reflection = [];
            if (isEven(height)) {
                for (var i = 0; i < height / 2; i++) { //loop for rows
                    for (var k = 0; k < ((height / 2) - 1) - i; k++) { //loop for placing appropriate spaces
                        str += " ";
                    }
                    for (var j = 0; j < i + 1; j++) { //loop for placing symbols
                        str += symbol;
                        str += symbol;
                    }
                    console.log(str);
                    reflection.push(str); //save created rows for later
                    str = ""; //reset
                }
                reflection.reverse();
                for (var l = 0; l < reflection.length; l++) { //log created rows in reverse order
                    console.log(reflection[l]);
                }
            } else if (!isEven(height)) {
                for (var i = 0; i < Math.trunc(height / 2); i++) {
                    for (var k = 0; k < (Math.trunc(height / 2)) - i; k++) {
                        str += " ";
                    }
                    str += symbol;
                    for (var j = 0; j < i; j++) {
                        str += symbol;
                        str += symbol;
                    }
                    console.log(str);
                    reflection.push(str);
                    str = "";
                }
                for (var m = 0; m < height; m++) {
                    str += symbol;
                }
                console.log(str);
                reflection.reverse();
                for (var l = 0; l < reflection.length; l++) {
                    console.log(reflection[l]);
                }
            }
            break;
    }
}