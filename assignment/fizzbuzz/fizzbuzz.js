/* Part 2: FizzBuzz
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
fizzbuzz */

function addItems() {
    var text1 = document.getElementById("input").value;
    var ul = document.getElementsByTagName("ul")[0];
    var l = document.createElement("li");

    for (var i = 0; i <= text1; i++)
        l = document.createElement("li");
    ul.appendChild(l);

    if (i % 5 == 0 && i % 3 == 0 && i !== 0) {
        document.getElementsByTagName("li")[i].innerHTML = "FizzBuzz";
    }
    else if (i % 5 == 0 && i !== 0) {
        document.getElementsByTagName("li")[i].innerHTML = "Buzz";
    }
    else if (i % 3 == 0 && i !== 0) {
        document.getElementsByTagName("li")[i].innerHTML = "Fizz";
    }
    else {
        document.getElementsByTagName("li")[i].innerHTML = i;
    }
}

document.getElementsByTagName("input")[0].addEventListener("change", addItems) 
