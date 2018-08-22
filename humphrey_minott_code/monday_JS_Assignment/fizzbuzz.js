/*
Part 2: FizzBuzz
Create an HTML page called fizzbuzz.html with an input box and unordered list.
Create a JavaScript page called fizzbuzz.js and inside the html page reference it.

The user will enter a positive number N.
Print From 0 to N;
Print For each multiple of 3, display "Fizz" instead of the number inside the unordered list of the html page. 
Print For each multiple of 5, display "Buzz" instead of the number inside the unordered list of the html page. 
Print For numbers which are multiples of both 3 and 5, display "FizzBuzz" instead of the number inside the unordered list of the html page.


e.g. Input value = 15 (modifying the ul element to display below)
1
2
fizz
4
buzz
fizz
7
8
fizz
buzz
11
fizz
13
14
fizzbuzz
*/


function print() {

   var inputValue = document.getElementById("inputNum").value;
   var inputValue2 = document.getElementById("inputNum2").value;
   var unorderedLi = document.getElementsByTagName("ul")[0];
   var listItem = document.createElement("li");



   for(var counter = 0; counter <= inputValue; counter++){
    listItem = document.createElement("li");
    unorderedLi.appendChild(listItem);
    if (counter % 5 == 0 && counter % 3 == 0 && counter !== 0){
        document.getElementsByTagName("li")[counter].innerHTML= "FizzBuzz";
    }
    else if (counter % 5 == 0 && counter !== 0){
        document.getElementsByTagName("li")[counter].innerHTML= "Buzz";
    } 
    else if (counter % 3 == 0 && counter !== 0){
        document.getElementsByTagName("li")[counter].innerHTML= "Fizz";
    } 
    else {
    document.getElementsByTagName("li")[counter].innerHTML= counter;
    }
   }
}

document.getElementsByTagName("input")[0].addEventListener("input",print)


