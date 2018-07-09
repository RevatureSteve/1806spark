/*
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/
function fib(n) {
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

/*2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/
function bubbleSort(numArray) {
    var sortTimes = numArray.length;
    for (var i = 0; i < sortTimes - 1; i++) {
        for (var j = 0; j < sortTimes - 1; j++) {
            if (numArray[j] > numArray[j + 1]) {
                var temp = numArray[j];
                numArray[j] = numArray[j + 1];
                numArray[j + 1] = temp;
            }
        }
    }
    return numArray;
}

/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/
function reverseStr(someStr) {
    var splitStr = someStr.split("");
    var reverseArray = splitStr.reverse();
    var joinStr = reverseArray.join("");
    return joinStr;
}

/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/
function factorial(someNum) {
    if (someNum != 1) {
        var result = someNum * factorial(someNum - 1);
        return result;
    } else {
        return 1;
    }
}
/*
5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/
function substring(someStr, length, offset) {
    var stringArray = someStr.split("");
    var subArray = [];
    for (var i = 0; i < length; i++) {
        subArray[i] = stringArray[i + offset];
    }
    return subArray.join("");
}

/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/
function isEven(someNum) {
    if(someNum < 2){
        return false;
    } else if(someNum == 2){
        return true;
    }

    return isEven(someNum - 2);
}

/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/
function isPalindrome(someStr) {
    var reversed = reverseStr(someStr);
    if (someStr == reversed) {
        return true;
    } else {
        return false;
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

function printShape(shape, height, character) {

    switch (shape) {
        case "Square": {
            for (var i = 0; i < height; i++) {
                var shapeStr = "";
                for (var j = 0; j < height; j++) {
                    shapeStr = shapeStr + character;
                }
                console.log(shapeStr);
            }
            break;
        }
        case "Triangle": {
            for (var i = 0; i < height; i++) {
                var shapeStr = "";
                for (var j = 0; j < i + 1; j++) {
                    shapeStr = shapeStr + character;
                }
                console.log(shapeStr);
            }
            break;
        }
        case "Diamond": {
            var space = height/2;
            for (var i = 0; i < height/2; i++) {
                var shapeStr = "";
                for (var j = 0; j < space; j++) {
                    shapeStr = shapeStr + " ";
                }
                space--;
                for (j = 1; j <= 2 * i - 1; j++) {
                    shapeStr = shapeStr + character;
                }
                console.log(shapeStr);
            }

            for (i = 0; i <= height/2; i++) {
                var shapeStr = "";
                for (j = 0; j <= space; j++) {
                    shapeStr = shapeStr + " ";
                }
                space++;
                for (j = 0; j <= ((height - i*2)-1); j++) {
                    shapeStr = shapeStr + character;
                }
                console.log(shapeStr);
            }
            
            break;
        } default: {

        }
    }

}

/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/
function traverseObject(someObj){
    var keys = Object.keys(someObj);
    var values = Object.values(someObj);

    for(var i = 0; i < keys.length; i++){
        console.log("Key value: "+keys[i]+", value: " + values[i]);
    }
    return values;
}

/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/

function deleteElement(someArr){
    console.log(someArr.length);
    someArr[2] = null;
    console.log(someArr.length);
}

/*
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/
function spliceElement(someArr){
    console.log(someArr.length);
    someArr.splice(3,1);
    console.log(someArr.length);
}
/*
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
    var john = new Person("John", 30);
*/

function Person(name, age){
    this.nameP = name;
    this.ageP = age;
}

/*
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
    var john = getPerson("John", 30);
*/
function getPerson(name,age){
    return new Person(name,age);
}