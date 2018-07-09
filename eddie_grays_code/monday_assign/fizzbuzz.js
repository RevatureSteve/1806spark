/*
Create an HTML page called fizzbuzz.html with an input box and unordered list.
Create a JavaScript page called fizzbuzz.js and inside the html page reference it.

The user will enter a positive number N.
Print From 1 to N;
Print For each multiple of 3, display "Fizz" instead of the number inside the unordered list of the html page. 
Print For each multiple of 5, display "Buzz" instead of the number inside the unordered list of the html page. 
Print For numbers which are multiples of both 3 and 5, display "FizzBuzz" instead of the number inside the unordered list of the html page.
*/

// document.getElementById("userNum").addEventListener("change", fizzbuzz);
var para = document.createElement("li");
var node;
var ele = document.getElementById("demo");

function fizzbuzz(N) {
    // var N = this.value;
    var arr = [];
    for (var i = 1; i <= N; i++) {
        var x = i / 3;
        var y = i / 5;
        if (Number.isInteger(x) == true && Number.isInteger(y) == true) { // checking to see if divisible by 3 AND 5

            node = document.createTextNode("FizzBuzz");
            para.appendChild(node);
            // element.appendChild(para);
            // arr.push("FizzBuzz");

        } else if (Number.isInteger(x) == true) { // checking to see if divisible by 3

            node = document.createTextNode("Fizz");
            para.appendChild(node);
            // element.appendChild(para);
            // arr.push("Fizz");

        } else if (Number.isInteger(y) == true) { // checking to see if divisible by 5

            node = document.createTextNode("Buzz");
            para.appendChild(node);
            // element.appendChild(para);
            // arr.push("Buzz");

        } else {

            node = document.createTextNode(" " + i);
            para.appendChild(node);
            // element.appendChild(para);
            // arr.push(i);
        }
    }
    console.log(arr);
}