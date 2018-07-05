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