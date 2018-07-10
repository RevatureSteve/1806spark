/*
The user will enter a positive number N.
Print From 0 to N;
Print For each multiple of 3, display "Fizz" instead of the number inside the unordered list of the html page. 
Print For each multiple of 5, display "Buzz" instead of the number inside thenordered list of the html page. 
Print For numbers which are multiples of both 3 and 5, display "FizzBuzz" instead of the number inside the unordered list of the html page.
*/




document.getElementById("listen").addEventListener("click", myFunction);

function myFunction() {
    var c;
    c = document.getElementById("id");
    console.log(c);
    var x;
    x = document.getElementById("demo").value;
    for (var i = 1; i <= x; i++) {
        var l = document.createElement("li");
        c.appendChild(l);
        if (i % 15 == 0) {
            l.innerHTML = "FizzBuzz";
        }
        else if (i % 5 == 0) {
            l.innerHTML = "Buzz";
        }
        else if (i % 3 == 0) {
            l.innerHTML = "Fizz";
        }
        else {
            l.innerHTML = i;
        }
    }
}

/*e.g. Input value = 15 (modifying the ul element to display below)
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
