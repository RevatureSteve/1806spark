//Part 2: FizzBuzz

/*
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


function fizzbuzz() {

    var hints = document.getElementById("list");  //remove hints
    while (hints.hasChildNodes()) {
        hints.removeChild(hints.firstChild);
    }

    var res = document.getElementById("guessbox").value;
    var res2 = document.getElementById("guessbox2").value;
    if(res > res2){
        let res3 = res;
        res = res2;
        res2 = res3;
    }
    for (var i = res; i <= res2; i++) {
        if (i % 3 == 0 && i % 5 != 0) {
            var num = document.createElement("li");
            var t = document.createTextNode("Fizz");
            num.appendChild(t);
            document.getElementById("list").appendChild(num);
        } else if (i % 3 != 0 && i % 5 == 0) {
            var num = document.createElement("li");
            var t = document.createTextNode("Buzz");
            num.appendChild(t);
            document.getElementById("list").appendChild(num);
        } else if (i % 3 == 0 && i % 5 == 0) {
            var num = document.createElement("li");
            var t = document.createTextNode("FizzBuzz");
            num.appendChild(t);
            document.getElementById("list").appendChild(num);
        } else {
            var num = document.createElement("li");
            var t = document.createTextNode(i);
            num.appendChild(t);
            document.getElementById("list").appendChild(num);
        }
    }
}