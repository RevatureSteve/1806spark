/*1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.*/

function fib(n) { //fib= fibonacci sequence, which is nature's number. Each index of a number 
    //it the addition of the current and previous number. 1+0=1;1+1=2;2+1=3;2+3=5;etc...
    //var fibonacci = [1, 1, 3, 5, 8, 13, 21, 34, 55, 89, 144]; //The fibonacci sequence

    if (n <= 1)

        return 1;

    return fib(n - 1) + fib(n - 2);
}
/*2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted */

var numArray = [564, 65, 45, 89, 756, 2, 46, 17, 25, 405];

function bubbleSort(numArray) {
    for (i = 0; i < numArray.length; i++) {
        //console.log(numArray[i]);
        //console.log(numArray[i + 1]);
        if (numArray[i] < numArray[i + 1]) { //This checks if the nth index 
            //is smaller or not than the nth + 1 index
            //console.log("yes");
            var x = numArray.shift(numArray[i]); //setting the nth element as x
            numArray.push(x); //placing the x value to the end of the array
            //numArray.shift(numArray[i]); //finally removing the nth element 
             //To stay within the same element in the array
            console.log("*** " + numArray);
 
        }
        else {
        }
    }
  console.log(numArray);
}

/*6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.*/
var someNum = 3;

function isEven(someNum) {

    if (someNum == 0) //If someNum is equal to 0
        return true; //If yes, then spit out true
    else if (someNum == 1) //If someNum is equal to 1
        return false; //Then spit out false
    else
        return isEven(someNum - 2); //If not meet previous conditions, sub 2 
}

/*10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.*/
var someArr = [1, 2, 3, 4, 5, 6, 7];

function deleteElement(someArr) {
    console.log("The length of your array is: " + someArr.length);
    delete someArr[2];
    console.log("3rd Element has been removed, your new length of your array is: "
        + someArr.length);
}








/*13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
    var john = getPerson("John", 30);*/
/*var John = {
    name: "John",
    age: 30,
}
function getPerson(name, age);*/









