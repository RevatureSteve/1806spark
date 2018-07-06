/*
    Loops in Javascript
*/
console.log('loop.js is ready for work!');
var names = ['mary', 'tom', 'anne', 'bobbert'];

function printNumberPlus1(num){
    console.log(num++);
    console.log(num);
    console.log(++num);
}

function printNumberMinus1(num){
    console.log(num--);
    console.log(num);
    console.log(--num);
}

function printArrayLength(arr){
    console.log("Array length is: " + arr.length);
}

function printPrettyArrays(arr){
    /*
        print each element of an array
        include the index and value
    */

   for (var i = 0; i < arr.length; i++){
    console.log("The index is: " + i + " array element " + arr[i]);
}
}

function removeElementFromArray(arr, element){
    for(var i = 0; i < arr.length; i++){
        if(element == arr[i]){
            arr.splice(i,1);
            return true; // code to stop looking
        }
    }

    return false; // element is not part of arr
}
