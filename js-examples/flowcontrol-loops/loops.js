/*
    Loops in Javascript
*/
console.log('loop.js ready for work!');
var names = ['mary', 'tom', 'anne', 'bobbert'];

function printNumberPlus1(num){
    console.log(++num);
}

function printNumberMinus1(num){
    console.log(--num);
}

function printArrayLength(arr){
    console.log("The length of your array is: " + arr.length);
}

function printPrettyArrays(arr){
    /*
        Print each element of an array
        Include the index and value
    */
   for ( var i = 0 ; i < arr.length ; i++ ) {
       console.log( i + ". " + arr[i] );
   }
}

function removeElementFromArray(arr, element){
    // how to use compound conditional in middle of for parentheses?
    for ( var i = 0 ; i < arr.length ; i++) {
        if (arr[i] == element) {
            arr.splice(i,1);
            return true;
        }
    }

    return false;
}