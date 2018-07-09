/* 1. Create a function named createRandomList that 
uses a for loop to create an array containing 10 random
numbers from 1 to 100 (use the JavaScript Math object to get a random number). 
The function should return that array. */
function createRandomList () {
    var myArray = [];
    for (var i = 0; i <= 10; i++) {
     var num = Math.random() * 10; //Set a variable called num to a random number and multiplied it by 10.
     myArray.push(num) // Addes num to the array for each time that the loop runs.
    }
return myArray;
}

/* 2. Call the createRandomList function and store 
the results in a variable named myRandomList. */
myRandomList = createRandomList();

/* 3. Use a for loop to access each element in the loop. Each 
time through the loop log a message to the console that looks something like this:
Item 0 in the array is 48
When you're done you should have output 10 lines to the console -- one for each element. 
*/
function accessEachElement () {
for (var i = 0; i < myRandomList.length; i ++) {    
    var num = myRandomList[i];
console.log("Item " + i + " in the array is " + num);
}
}