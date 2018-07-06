
/*
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function fib(n) {
    if (n < 0){
        return undefined;
    }
    if (n == 0){
        return 0;
    }
    if (n == 1){

        return 1;
    }
    if (n == 2){
        return 1;
    }
    return fib(n - 1) + fib(n-2);
}

/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/

function bubbleSort(numArray) {
    //Create a copy of the array
    var sortedArray = numArray.slice();
    var arrayLength = sortedArray.length;
    for (var i = 0; i < arrayLength; i++) {
        //Number of passes = length of array;
        for (var j = 0; j < arrayLength - i - 1; j++) {
            //Each pass is one less than the previous pass, because the last number is sorted
            if (sortedArray[j] > sortedArray[j + 1]) {
                //Switch numbers
                var numHolder = sortedArray[j];
                sortedArray[j] = sortedArray[j + 1];
                sortedArray[j + 1] = numHolder;
            }
        }
    }
    return sortedArray;
}

/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.

*/

function reverseStr(someStr){
    var stringArray = someStr.split("");
    var reverseArray = stringArray.reverse();
    var reverseStr = reverseArray.join();
    return reverseStr;
}

/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/

function factorial(someNum){
    if (someNum < 1){
        return 0;
    }
    if (someNum = 1){
        return 1;
    }
    return someNum * factorial(someNum - 1);
}