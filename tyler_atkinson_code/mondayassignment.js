/*Part 1
/* 1. Create a function named createRandomList that 
uses a for loop to create an array containing 10 random
numbers from 1 to 100 (use the JavaScript Math object to get a random number). 
The function should return that array. */


    // function getRandomInt(min, max) {
    //     "use strict";
    //     if (max < min) {
    //         // Swap min and max
    //         [min, max] = [min, max];
    //     }
    
    //     // Generate random number n, where min <= n <= max
    //     let range = max - min + 1;
    //     return Math.floor(Math.random() * range) + min;
    // }
    
    // let values = Array.from({length: 10}, () => getRandomInt(0, 100));
    
    // console.log(values);




function random100(){
    return Math.floor(Math.random() * 100) + 1;
}


function createRandomList() {
    let randomList = [];
    for (let i = 0; i < 10; i++) {
        randomList.push(random100());
    }
    return randomList
};

// /* 2. Call the createRandomList function and store 
// the results in a variable named myRandomList. */

let myRandomList = createRandomList();
console.log(myRandomList);

/* 3. Use a for loop to access each element in the loop. Each 
time through the loop log a message to the console that looks something like this:
Item 0 in the array is 48
When you're done you should have output 10 lines to the console -- one for each element. 
*/

for (let i = 0; i < myRandomList.length; i++) {
    console.log('Item ' + i + ' in the array is ' + myRandomList[i]);
}


function fizzBuzz(){

var fizzInput = document.getElementById("fizzInput");
var fizzOutput = document.getElementById("fizzList");
var listItems = "";
var n = fizzInput.value;
    while(fizzList.firstChild){
        fizzList.removeChild(fizzList.firstChild)
    }

for (i = 1; i <= n; i++) {

    listItems += "<li>";

    if ((i % 3 === 0) && (i % 5 === 0)) {
        listItems += "fizzbuzz";
    }
    else if (i % 3 === 0) {
        listItems += "fizz";
    }
    else if (i % 5 === 0) {
        listItems += "buzz";
    }
    else {
        listItems += i;
    }
    listItems += "</li>";

}

fizzList.innerHTML += listItems;



}

document.addEventListener("input", fizzBuzz)