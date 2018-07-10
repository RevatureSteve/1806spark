// /* 1. Create a function named createRandomList that 
// uses a for loop to create an array containing 10 random
// numbers from 1 to 100 (use the JavaScript Math object to get a random number). 
// The function should return that array. */

function createRandomList (){

var myArray =[];
for (var i = 0 ; i < 10 ; i++) {
     myArray[i] = Math.floor(Math.random() * 101);     // returns a random integer from 0 to 100
}
return myArray;

}
// /* 2. Call the createRandomList function and store 
// the results in a variable named myRandomList. */
var myRandomList = createRandomList ();

// /* 3. Use a for loop to access each element in the loop. Each 
// time through the loop log a message to the console that looks something like this:
// Item 0 in the array is 48
// When you're done you should have output 10 lines to the console -- one for each element. 
// */

for ( i = 0 ; i < myRandomList.length ; i++) {
    console.log(" Item " + i + " in the array is " + myRandomList [i] )

}

// Create an HTML page called fizzbuzz.html with an input box and unordered list.
// Create a JavaScript page called fizzbuzz.js and inside the html page reference it.

// The user will enter a positive number N.
// Print From 0 to N;
// Print For each multiple of 3, display "Fizz" instead of the number inside the unordered list of the html page. 
// Print For each multiple of 5, display "Buzz" instead of the number inside the unordered list of the html page. 
// Print For numbers which are multiples of both 3 and 5, display "FizzBuzz" instead of the number inside the unordered list of the html page.





document.getElementById("submit").addEventListener("click", FizzBuzz) 


function FizzBuzz(){
    
var N = parseInt(document.getElementById("number").value)
var ul =document.getElementById("list");
for (var i = 1; i <= N ; i++ ){
var value ="" ;
 
if (i % 3 == 0 && i % 5 == 0){
    value += "FizzBuzz"

    }
 else if  (i % 5 == 0){
    value += "Buzz"
    }
    
 else if (i % 3 == 0){
    value += "Fizz"
    

    }
    else { 
        value = i;
    }

var li = document.createElement("li")
li.appendChild(document.createTextNode(value));
ul.appendChild(li)
}; 
}
