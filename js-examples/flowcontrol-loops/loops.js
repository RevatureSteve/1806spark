/*
    Loops in Javascript
*/
console.log('loop.js ready for work!')


function printNumberPlus1(num){
    console.log(num++); // ++ means add 1, num++ is post increment
    console.log(num);

    console.log(++num); // pre increment
}

function printNumberMinus1(num){
    console.log(--num);
    return ++num;
    console.log('after return'); // unreachable code aka bad
}

function printArrayLength(arr){ // this is a function
    console.log('The length of your array is: ' + arr.length) // arr.length is a property
}
var names = ['mary', 'tom', 'anne', 'bobbert'];
function printPrettyArrays(arr){
    /*
        Print each element of an array
        Include the index and value
    */
   for(var i = 0; i < arr.length; i++){
       console.log('The index is: ' + i + ' the value is: ' + arr[i] + '.');
   }

   return arr[arr.length-1]
}
/*
    how can I add/remove an element to an array?
    arr.push('new element'); // adds an element to the end
    arr.pop() // returns the last elemnt and takes it out of the array
*/

function removeElementFromArray(arr, element){
    // console.log('hi');
    // printPrettyArrays(arr);

    for(var i = 0; i < arr.length; i++){
        console.log("The element is: " + element + " the index value is: " + arr[i]);
        if(element == arr[i]){
            // console.log("****the element and the index value are equal");
            arr.splice(i, 1);
            return true; // stop looking for the element
            // printPrettyArrays(arr);
        }
    }

    return false;
}
