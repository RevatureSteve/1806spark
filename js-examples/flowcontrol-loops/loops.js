/*
    Loops in Javascript
*/

console.log('loop.js rday for work')



function printNumberPlus1(i){
    console.log(i++) // <-- this is a post increment DOES NOTHING TO YOUR NUMBER UNTIL THE NEXT LINE.
    console.log(i) // <-- this is just num increment (means add one)
    console.log(++i) // <-- this is a pre increment (means add two)
}

function printNumberMinus1(i){
    console.log(i--) // <-- this is a post deccrement DOES NOTHING TO YOUR NUMBER UNTIL THE NEXT LINE.
    console.log(i) // <-- this is just num decrement (means add one)
    console.log(--i) // <-- this is a pre decrement (means add two)
    return i;
    console.log('unreachable code if it is after a return statement')
}

function printArrayLength(arr){
    console.log('the length of your array is: ' + arr.length);  
}
var names = ['mary', 'tom', 'anne', 'bobbert']; //length is 4
function printPrettyArrays(arr){
/*
print each element of an array
include the index and value
*/

for(var i=0; i < arr.length; i++) /*i=0 because index starts at zero.*/{
    console.log("The Index is: " + i + "the value is: " + arr[i] + ".")
// 0 < 4: index zero, value mary
// 1 < 4: index one, value tom
// 2 < 4: index two, value anne
// 3 < 4: index three, value bobbert
    return (arr[arr.length-1]+ " is the last in the index."); //this would return the LAST element.
}
}


/*

    How can i add / remove an element to an array?
    arr.push('new element'); // adds an element to the end.
    arr.push() // returns the last element and takes it out of the array.
*/

function removeElementFromArray(arr, element){
    console.log('Removing this element from array: ');
    //printPrettyArrays(arr);

for(var i = 0; i < arr.length; i++){
    console.log("The element is: " + element + " the index value is: " + arr[i]);
    if(element ==arr[i])
        console.log('the element and index value are equal')   

    arr.splice(1,1)
    return true;
}
}
