

/* 1. Create a function named createRandomList that 
uses a for loop to create an array containing 10 random
numbers from 1 to 100 (use the JavaScript Math object to get a random number). 
The function should return that array. 
*/


function createRandomList() {
    var numbers = [];

    for (var i = 0; i < 10; i++) {
        numbers[i] = (Math.floor(Math.random() * 100) + 1)
    }

    return numbers;
}






/* 2. Call the createRandomList function and store 
the results in a variable named myRandomList. */


    var x = []
    x = createRandomList()
    var myRandomList = x









/* 3. Use a for loop to access each element in the loop. Each 
time through the loop log a message to the console that looks something like this:
Item 0 in the array is 48
When you're done you should have output 10 lines to the console -- one for each element. 
*/

for (var i = 0; i < 10; i++) {

console.log("Item " + i + " in the array is " + myRandomList[i])

}
