/*
    Loops in Javascript
*/

var names = ['mary', 'tom', 'anne', 'bobbert'];

function printNumberPlus1(num){
    console.log('printNumberPlus1');
    console.log(num++);
    
}

function printNumberMinus1(num){
    console.log(num--);
}

function printArrayLength(arr){
    console.log("The length of the array is: " + arr.length);
}

var names = ['Mary', 'Tom', 'Jeana','Bobby'];
function printPrettyArrays(arr){
    /*
    preint each element of an array 
    Include the index and value
    */

    for (let i = 0; i < arr.length; i++) {
        console.log("Index: " + i + " Value: " + arr[i]);
    }
}
/*
    How can I add/remove an element to an array?
    arr.push('new element); //adds an element at the end
    arr.pop(); returns the last element and takes it out of the array
*/
function removeElementFromArray(arr, element){
    // printPrettyArrays(arr);
    // arr.splice(arr.indexOf(element),1);
    // console.log(element + " removed");

    for (let i = 0; i < arr.length; i++) {
        if(element == arr[i]){
            console.log("element is in array");
        }
    }
}
