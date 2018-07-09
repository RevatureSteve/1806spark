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
fizzbuzz
*/

function fizzBuzz() {
    var a = document.getElementById("someNum").value;
    // Assign entered value to variable a
    var b = document.createElement("UL");
    b.setAttribute("id", "list");
    document.body.appendChild(b);
    // Create a ul element with id = "list" and append it as the last child of body element

    for (var i = 1; i <= a; i++) {
        var c = document.createElement("LI");
        // Create li for variable a amount of times
        if (i%3 == 0 && i%15 !== 0) {
            var d = document.createTextNode("Fizz");
            // For each multiple of 3 but not multiple of 15, display "Fizz" instead of the number
        } else if (i%5 == 0 && i%15 !== 0) {
            var d = document.createTextNode("Buzz");
            // For each multiple of 5 but not multiple of 15, display "Buzz" instead of the number
        } else if (i%15 == 0) {
            var d = document.createTextNode("FizzBuzz");
            // For each multiple of 15, display "FizzBuzz" instead of the number
        } else {
            var d = document.createTextNode(i);
            // Otherwise, display number
        }
        c.appendChild(d);
        // Append text node as the last child of li
        document.getElementById("list").appendChild(c);
        // Append li as the last child of ul with id = "list"
    }
}