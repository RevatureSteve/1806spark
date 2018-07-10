/*
Create an HTML page called fizzbuzz.html with an input box and unordered list.
Create a JavaScript page called fizzbuzz.js and inside the html page reference it.

The user will enter a positive number N.
Print From 1 to N;
Print For each multiple of 3, display "Fizz" instead of the number inside the unordered list of the html page. 
Print For each multiple of 5, display "Buzz" instead of the number inside the unordered list of the html page. 
Print For numbers which are multiples of both 3 and 5, display "FizzBuzz" instead of the number inside the unordered list of the html page.
*/

document.getElementById("userNum").addEventListener("change", fizzbuzz);

function fizzbuzz() {
    var liLength = document.getElementByTagName("li").length;
    var list = document.getElementById("list");
    for (var i = 0; i < liLength; i++) {
        list.removeChild(list.childNodes[1]);
    }
    var N = parseInt(event.target.value);
    for (var i = 1; i <= N; i++) {
        var x = i / 3;
        var y = i / 5;
        var show = "";
        if (Number.isInteger(x) == true && Number.isInteger(y) == true) { // checking to see if divisible by 3 AND 5
            show += "fizzbuzz";
        } else if (Number.isInteger(x) == true) { // checking to see if divisible by 3
            show += "fizz";
        } else if (Number.isInteger(y) == true) { // checking to see if divisible by 5
            show += "buzz";
        } else {
            value += i;
        }
        var item = document.createElement("li");
        item.appendChild(document.createTextNode(value));
        list.appendChild(item);
    }
}