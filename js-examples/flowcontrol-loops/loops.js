/*
    Loops in Javascript
*/
console.log('loop.js ready for work!');

var names = ['mary', 'tom', 'anne', 'bobbert'];

function printNumberPlus1(num){
    //++num pre increment, num++ post increment
    console.log(++num);
}

function printNumberMinus1(num){
    console.log(--num);
}

function printArrayLength(arr){
    console.log('The length of your array is: ' + arr.length);
}

function printPrettyArrays(arr){
    /*
        Print each element of an array
        Include the index and value
    */
   for(var i = 0; i < arr.length; i++){
       console.log("The index is: " + i + "The value is: " + arr[i]);
   }
}

/*
    how can I add/remove an element to an array?
    arr.push('new element');
    arr.pop();
*/

function removeElementFromArray(arr, element){
    for (var i = 0; i < arr.length; i++){
        if (element == arr[i]){
            arr.splice(i,1);
            return true; // stop looking for element, we found it!
        }
    }
    return false;
}
