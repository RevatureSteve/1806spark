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
document.addEventListener("change", appendItems);

var getNum;

function appendItems() {
    getNum = document.getElementById("selectedNum").value;
    var length = document.getElementsByTagName("li").length;
    var insertItem = document.getElementById("item");
    for (var i = 0; i < length; i++) {
        insertItem.removeChild(insertItem.childNodes[0]);
    }

    for (let i = 1; i <= getNum; i++) {
        var char = "";
        if (i % 3 == 0) {
            char += "fizz";
        }
        if (i % 5 == 0) {
            char += "buzz";
        }
        if (i % 3 !== 0 && i % 5 !== 0) {
            char += i;
        }
        var node = document.createElement("li");
        node.appendChild(document.createTextNode(char));
        insertItem.appendChild(node);
    }
}