/*
    1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.

*/

function fib(n) {
    return n
}

/*
    2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.

*/


// function to sort the array
function bubbleSort(numArray) {
    //got confused 
      var temp = numArray; // to hold value that is be passed arround
    for (var a = 0; a < numArray.lenght; a++) {
        for (var b = 1; b < numArray.lenght; b++) {

            if (numArray[b - 1] > numArray[b]) {
               temp(numArray, b-1, b);


            }
        }
        return numArray;
    }

}

// //6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator. (oh no i just saw this )

function isEven(aNumber) {
       // oh man, i messed this up i used % the remainded operator after i re-read
    if (aNumber %2 == 0) {
        aNumber = "false"
    }
    else {
        aNumber = "true"
    }

}


// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.

function deleteElemet(){
    var somerr= ["one", "two","three","four","five"];
    somerr.length(); //count items in array above
    delete somerr[2];  // this will delete 3 item in array 
    somerr.length(); // recount array items after one is deleted/removed

}

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.

function spliceElement(){
    var somerr= ["one", "two","three","four","five"];
    somerr.length(); // count how many items are in array
    splice.ssomerr[2]; // remove the 3rd item in array located at index[2]
    somerr.length(); // recount items in array fyi should be one less than before

}


