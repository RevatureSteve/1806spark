/*1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.*/
function fibonacci(num){
    var a = 1, b = 0, temp;
    while (num >= 0){
        temp = a;
        a = a + b;
        b = temp;
        num--;
    }
    return b;
}

/*2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.*/
var num = [2,4,6,1,0]
function bubbleSort(numArray){
    for (i = 0; i <= numArray.length-1; i++){
        if (numArray[i] > numArray[i+1]){
            var temp = numArray[i+1];
            numArray[i+1] = numArray[i];
            numArray[i] = temp;
            i = i-2;
        }
    }   return num;
}
    

/*3. Reverse String
Define function: reverseStr(someSt)
Reverse and return the String.*/
function reversestr(someStr){
    var o ='';
    for (var i = str.length - 1; i >= 0; i--)
    o += someStr[i];
    return o;
}

/*4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.*/
function factorial(someNum){
    if (someNum === 0 || someNum === 1)
    return 1;
    return factorial(someNum - 1) * someNum;
}

/*5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.*/

/*6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.*/

/*7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false*/

/*8. Shapes
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


/*9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.*/

/*10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.*/
SomeArr = ['green', 'red', 'blue', 'white']
function deleteElement(someArr) {
   someArr.length;
   delete someArr[1];
}

/*11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.*/
SomeArr = ['green', 'red', 'blue', 'white']
function spliceElement(someArr) {
   someArr.length;
   someArr.splice(1,1);
   someArr.length;
}

/*12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);*/

/*13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);
*/