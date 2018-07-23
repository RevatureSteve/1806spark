
// Part 2: FizzBuzz
// Create an HTML page called fizzbuzz.html with an input box and unordered list.
// Create a JavaScript page called fizzbuzz.js and inside the html page reference it.

// The user will enter a positive number N.
// Print From 0 to N;
// Print For each multiple of 3, display "Fizz" instead of the number inside the unordered list of the html page. 
// Print For each multiple of 5, display "Buzz" instead of the number inside the unordered list of the html page. 
// Print For numbers which are multiples of both 3 and 5, display "FizzBuzz" instead of the number inside the unordered list of the html page.


// e.g. Input value = 15 (modifying the ul element to display below)
// 1
// 2
// fizz
// 4
// buzz
// fizz
// 7
// 8
// fizz
// buzz
// 11
// fizz
// 13
// 14
// fizzbuzz
//var outtie=15; // prompt user for input

//var person = prompt("Please enter your name", "Harry Potter");
document.getElementById("lookingForText").addEventListener("change", fizzBuzz);

function fizzBuzz() {
    var n = this.value; /// reference to what ever element call it
    var someFiz = []; // the value will be undefine until this.value return the user input
//    var para = document.createElement("ul");
//    var node = document.createTextNode("fizzz");
//          para.appendChild(node);
//          document.body.appendChild(para);
    for (a = 1; a < n; a++) {
        b = a / 3;
        c = a / 5;
        if (Number.isInteger(b) == true && Number.isInteger(c) == true) {
            //document.body.innerHTML=
            var para = document.createElement("li");
            var node = document.createTextNode( someFiz.push()  +"fizzbuzz");
                  para.appendChild(node);
                  document.body.appendChild(para);
                //   someFiz.push("fizzbuzz");
            // someFiz.push("fizzbuzz"); // THIS WILL CHECK THE NUMBER IF IT IS DIVISIBLE BY 3 AND BOTH 5

        }
        else if (Number.isInteger(b) == true) {
           var fizz =document.createElement("ul");

         someFiz.push("fizz"); //DIVIDED BY 3 ONLY
        }
        else if (Number.isInteger(c) == true) {
            var para = document.createElement("li");
            var node = document.createTextNode( someFiz.push()  +"fizz");
                  para.appendChild(node);
                  document.body.appendChild(para);

            //someFiz.push("buzz"); //DIVIDED BY 5 ONLY
        }
        else {
            var para = document.createElement("li");
            var node = document.createTextNode( someFiz.push(a)  +" fizzbuzz");
                  para.appendChild(node);
                  document.body.appendChild(para);
            // someFiz.push(a); //DIVIDED BY 1 WHICH DONT MEAN NOTHING
        }
    }
    console.log(someFiz);
}
