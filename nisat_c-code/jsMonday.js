
/* 1. Create a function named createRandomList that 
uses a for loop to create an array containing 10 random
numbers from 1 to 100 (use the JavaScript Math object to get a random number). 
The function should return that array. */

function createRandomList() {
    var numbers = [];
    for (var i = 0; i < 10; i++) {
        numbers[i] = (Math.floor(Math.random() * 100) + 1)
    } // numbers.push(x);
        return numbers;
        //printing random values but now i need to store the values in array

    }




/* 2. Call the createRandomList function and store 
the results in a variable named myRandomList. */
var y = createRandomList();
var myRandomList = [];
myRandomList = y



/* 3. Use a for loop to access each element in the loop. Each 
time through the loop log a message to the console that looks something like this:
Item 0 in the array is 48
When you're done you should have output 10 lines to the console -- one for each element. 
*/
var i = myRandomList;
for (var i = 0; i < 10; i++) {
    console.log ("item " + i + " in the array is " + myRandomList[i])
}
