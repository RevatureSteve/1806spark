/* 1. Create a function named createRandomList that 
uses a for loop to create an array containing 10 random
numbers from 1 to 100 (use the JavaScript Math object to get a random number). 
The function should return that array. */


/* 2. Call the createRandomList function and store 
the results in a variable named myRandomList. */


/* 3. Use a for loop to access each element in the loop. Each 
time through the loop log a message to the console that looks something like this:
Item 0 in the array is 48
When you're done you should have output 10 lines to the console -- one for each element. 
*/

var myRandomList = []; //

function createRandomList(){ //
    for (var i = 1; i <= 10; i++)
    {
       myRandomList.push(Math.floor (Math.random ()*101)) // push pushes to the end of the array. Math.floor rounds the number down to the nearest integer (whole number). Math.random between 0 and 1 (does not include 0 and 1)
    }
    return myRandomList;
}
function myLeadArray(){
    for (var i = 0; i < myRandomList.length; i++) // for loop compares i to the index length
    {
        console.log( ' index is: ' + i + ' index is ' + myRandomList[i]); // prints what index its at and what the variable is at that index
    }
    return "completed";
}
    
