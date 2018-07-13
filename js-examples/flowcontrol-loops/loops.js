/*
    Loops in Javascript
*/
console.log('loop.js ready for work!');


function printNumberPlus1(num){
    ++num; //++ means add 1, num++ is post increment
    console.log(num); //++ means add 1

    console.log(++num); //++num pre
}
                        // 5
function printNumberMinus1(num){
    console.log(--num);
}

function printArrayLength(arr){
    console.log("The length of your array is: " + arr.length);
}
var names = ['mary', 'tom', 'anne', 'bobbert']; // length? 4
function printPrettyArrays(arr){
    /*
        Print each element of an array
        Include the index and value
    */
   for ( var i = 0 ; i < arr.length ; i++ ) {
       console.log( i + ". " + arr[i] );
   }
}
/*
    how can I add/remove an element to an array?
    arr.push('new element'); //adds an element to the end
    arr.pop() //returns the last element and takes it out of the array

*/

                                        // "tom"
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