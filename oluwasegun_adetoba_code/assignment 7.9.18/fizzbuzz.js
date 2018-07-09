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
*/


function fizzbuzz(){
    var res = document.getElementById("num").value;
    for (var i = 1; i <= res; i++) {
        if (i % 3 == 0 && i % 5 != 0) {
            var num = document.createElement("li");
            var x = document.createTextNode("Fizz");
            num.appendChild(x);
            document.getElementById("list").appendChild(num); 
        } else if (i % 3 != 0 && i % 5 == 0) {
            var num = document.createElement("li");
            var x = document.createTextNode("Buzz");
            num.appendChild(x);
            document.getElementById("list").appendChild(num);   
        } else if (i % 3 == 0 && i % 5 == 0) {
            var num = document.createElement("li");
            var x = document.createTextNode("FizzBuzz");
            num.appendChild(x);
            document.getElementById("list").appendChild(num); 
        } else {
            var num = document.createElement("li");
            var x = document.createTextNode(i);
            num.appendChild(x);
            document.getElementById("list").appendChild(num); 
            
        }
    }   
}