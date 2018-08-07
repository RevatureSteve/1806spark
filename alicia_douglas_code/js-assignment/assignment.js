
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

function printShape(shape, height, character) {
    var str = "";
    switch (shape) {
        case "Square":
            for (var f = 0; f < height; f++) {
                str += character;
            };
            for (var i = 0; i < height; i++) {
                console.log(str);
            };
            break;
        case "Triangle":
            for (var i = 0; i < height; i++) {
                str += character;
                console.log(str);
            };
            break;
        case "Diamond":
            var diamond = [];
            var half = height / 2 - .5;
            for (var i = 0; i < height; i++) {
                diamond.push(" ");
            };
            for (var f = 0; f < height; f++) {
                if (f < height / 2) {
                    diamond[half - f] = character;
                    diamond[half + f] = character;
                } else {
                    diamond[half - (height - f)] = " ";
                    diamond[half + (height - f)] = " ";
                };
                console.log(diamond.join(""));
            };
    };
}

/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/

function reverseStr(someStr) {
    var reverseString = "";
    for (var i = someStr.length - 1; i >= 0; i--) {
        reverseString += someStr.charAt(i);
    };
    return reverseString;
}

/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/

function bubbleSort(numArray) {
    var placeholder;
    for (var f = 0; f < numArray.length - 1; f++) {
        for (var i = 0; i < numArray.length; i++) {
            if (numArray[i] > numArray[i + 1]) {
                placeholder = numArray[i + 1];
                numArray[i + 1] = numArray[i];
                numArray[i] = placeholder;
            }
        }
    }
    return numArray;
}

/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/

function isPalindrome(someStr) {
    for (var i = 0; i < someStr.length; i++) {
        if (someStr.charAt(i) == " ") {
            someStr = someStr.slice(i, i);
        }
    }
    var reverseString = reverseStr(someStr);
    if (reverseString == someStr) {
        return true;
    } else {
        return false;
    }
}

/*
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function fib(n) {
    var fibSequence = [];
    fibSequence.push(1);
    fibSequence.push(1);
    for (var i = 2; i < n; i++) {
        fibSequence.push(fibSequence[i - 2] + fibSequence[i - 1]);
    }
    console.log(fibSequence[n - 1]);
}

/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/

function factorial(someNum) {
    var factorial = recursiveFactorial(someNum);
    console.log(factorial);
}

var recursiveFactorial = function (n) {
    if (n == 0) {
        return 1;
    } else {
        return n * recursiveFactorial (n - 1);
    }
}

