/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/

var x;
var y;
var z;

function reverseStr(someStr) {
    x = someStr.split("");
    y = x.reverse();
    z = y.join("");
    return z;
}

/* 
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/

var someNum;
var newNum;
var x;

function isEven(someNum) {
    newNum = Math.abs(someNum);
    x = newNum / 2;

    if (Number.isInteger(x) == true) { // if number is even
        return true;
    } else if (Number.isInteger(newNum) == false) { // if number has decimal
        console.log('Please use an integer.')
    } else if (Number.isInteger(x) == false) { // if number is odd
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
*/

function printShape(shape, height, character) {
    var arr = [];
    switch (shape) {
        case "Square":
            for (var i = 0; i < height; i++) {
                if (i == 0) {
                    for (var t = 0; t < height; t++) {
                        arr.push(character);
                    }
                }
                console.log(arr);
            }
            break;
        case "Triangle":
            for (var i = 0; i < height; i++) {
                arr.push(character);
                console.log(arr.join(''));
            }
            break;
        case "Diamond":
            break;
        default:
            console.log('Try again.');
    }
}

/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/

var someArr;

function deleteElement(someArr) {
    console.log(someArr.length);
    delete someArr[2];
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

var someArr;

function spliceElement(someArr) {
    console.log(someArr.length);
    someArr.splice(2, 1);
    console.log(someArr.length);
}