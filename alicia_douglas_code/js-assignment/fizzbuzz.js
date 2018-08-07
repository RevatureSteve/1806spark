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

document.getElementById("num").addEventListener("change", printN);

function printN(){
    var liLength = document.getElementsByTagName("li").length;
    var ul = document.getElementsByTagName("ul")[0];
    for (var i = 0; i < liLength; i++){
        ul.removeChild(ul.childNodes[1]);
    }
    var n = parseInt(event.target.value);
    for (var i = 1; i <= n; i++){
        var value = "";
        if(i % 3 == 0){
            value += "fizz";
        };
        if (i % 5 == 0){
            value += "buzz";
        };
        if (i % 3 != 0 && i % 5 != 0){
            value += i;
        };
        var li = document.createElement("li");
        li.appendChild(document.createTextNode(value));
        ul.appendChild(li);
    };
}