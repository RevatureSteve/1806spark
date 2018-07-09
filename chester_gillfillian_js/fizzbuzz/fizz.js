/*Part 1
 1. Create a function named createRandomList that 
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

function createRandomList(){
    var someRAy = []
    for (var ran=0; ran<10; ran++){
        // conaole.log(" The random number is idk : ")
       // let randomList = Math.floor(Math.random() * 100)
      
       let randomList = Math.random() * 100; // store the the random number generator in randomlist
       someRAy.push(Math.round(randomList)) //someRay.push the math function to the array

    
}
return someRAy;

}

function createRandomListA(){
    var someRAy = []
    for (var ran=0; ran<10; ran++){
        // conaole.log(" The random number is idk : ")
        let randomList = Math.floor(Math.random() * 100)
       //let randomList = Math.random() * 100; // store the the random number generator in randomlist
       someRAy.push(randomList) //someRay.push the math function to the array the math. round is removed .

    
}
return someRAy;
}


