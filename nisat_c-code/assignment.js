/* Reverse String
 Define function: reverseStr(someStr)
 Reverse and return the String.
*/
//changes the string to an array when broken into letter, reverse is a method for arrays
function reverse(s) {
    return s.split('').reverse().join('');
}

/* Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/

function isPalindrome(s) {
    var rs = reverse(s);
    if (s == rs) {
        return true;
    } else {
        return false;
    }

}

/* Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/


function isEven(input) {
    var number = input.toString();
    var onesDigit = number.substring(number.length - 1, number.length);
    /*use the num to string and then substring(start, end)
    (length-1, length)*/
    if (onesDigit == '0' || onesDigit == '2' || onesDigit == '4' || onesDigit == '6' || onesDigit == '8') {
        return true;
        // console.log('number is even');
        // } else {
    }
    return false;
    // console.log('check if its going to else')
    // console.log('number is odd');
}

/*Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.*/

someArr = ["nisat", "tasin", "alex", "obosa"];
function deleteElement(someArr) {
    console.log(someArr);
    console.log("this is the length of the array BEFORE I delete an element: " + someArr.length);
    delete someArr[2];
    console.log(someArr);
    console.log("this is the length of the array AFTER I deltete an element: " + someArr.length);
}

/*Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.*/
function spliceElement(someArr) {
    console.log("pre-splice array: " + someArr);
    console.log("this is the length of the array BEFORE i splice an element: " + someArr.length);
    someArr.splice(2, 1);   
    console.log("post-splice array: " + someArr);
    console.log("this is the length of the array AFTER i splice an element: " + someArr.length);
}





