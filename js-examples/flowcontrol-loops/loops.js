/*
    Loops in Javascript
*/
<<<<<<< HEAD
<<<<<<< HEAD

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
=======
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
console.log('loop.js ready for work!');


function printNumberPlus1(num){
    ++num; //++ means add 1, num++ is post increment
    console.log(num); //++ means add 1

    console.log(++num); //++num pre
}
                        // 5
function printNumberMinus1(num){
    console.log(num--); // 5 printed
    console.log(num); // 4 printed
    console.log(num--); // 4 
    return num; // 3
    console.log('after return'); // unreachable code aka bad..
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

   for( var i = 0; i < arr.length; i++){
     console.log("The index is: " + i + " the value is: " + arr[i] + ".");
   }
   // 0 < 4: index 0 value mary
   // 1 < 4: index 1 value tom
   // 2 < 4: index 2 value anne
   // 3 < 4: index 3 value bobbert

   // how can I return the last element
   return arr[arr.length-1];

}
/*
    how can I add/remove an element to an array?
    arr.push('new element'); //adds an element to the end
    arr.pop() //returns the last element and takes it out of the array

*/

                                        // "tom"
function removeElementFromArray(arr, element){
    // console.log('hi');
    // printPrettyArrays(arr);

    for(var i = 0; i < arr.length; i++){
        // console.log("The element is : " + element + " the index value is: " + arr[i]);
        if(element == arr[i]){
            // console.log('****element and index value are equal****');
            arr.splice(i,1);
            return true; // stop looking for element, we found it!
            // printPrettyArrays(arr);
        }
    }

    return false;


}


function foo(){
    for(var i = 0; i < 3; i++){
        console.log('hello');
    }
    // 0 < 3: hello
    // 1 < 3: hello
    // 2 < 3: hello;
<<<<<<< HEAD
}
=======
}
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
