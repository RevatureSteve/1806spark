function fizzBuzz() {
    var a = document.getElementById("someNum").value;
    // Assign entered value to variable a
    var b = document.getElementById("someNum2").value;
    // Assign entered value to variable b
    var c = document.createElement("UL");
    c.setAttribute("id", "list");
    document.body.appendChild(c);
    // Create a ul element with id = "list" and append it as the last child of body element
    var a = parseInt(a); //parses a string and returns an integer
    var b = parseInt(b);


    if (a <= b) {
        for (a; a <= b; a++) {
            var d = document.createElement("LI");
            // Create li for variable a amount of times
            if (a%3 == 0 && a%15 !== 0) {
                var e = document.createTextNode("Fizz");
                // For each multiple of 3 but not multiple of 15, display "Fizz" instead of the number
            } else if (a%5 == 0 && a%15 !== 0) {
                var e = document.createTextNode("Buzz");
                // For each multiple of 5 but not multiple of 15, display "Buzz" instead of the number
            } else if (a%15 == 0) {
                var e = document.createTextNode("FizzBuzz");
                // For each multiple of 15, display "FizzBuzz" instead of the number
            } else {
                var e = document.createTextNode(a);
                // Otherwise, display number
            }
            d.appendChild(e);
            // Append text node as the last child of li
            document.getElementById("list").appendChild(d);
            // Append li as the last child of ul with id = "list"
        }
    } else {
        for (b; b <= a; b++) {
            var d = document.createElement("LI");
            // Create li for variable a amount of times
            if (b%3 == 0 && b%15 !== 0) {
                var e = document.createTextNode("Fizz");
                // For each multiple of 3 but not multiple of 15, display "Fizz" instead of the number
            } else if (b%5 == 0 && b%15 !== 0) {
                var e = document.createTextNode("Buzz");
                // For each multiple of 5 but not multiple of 15, display "Buzz" instead of the number
            } else if (b%15 == 0) {
                var e = document.createTextNode("FizzBuzz");
                // For each multiple of 15, display "FizzBuzz" instead of the number
            } else {
                var e = document.createTextNode(b);
                // Otherwise, display number
            }
            d.appendChild(e);
            // Append text node as the last child of li
            document.getElementById("list").appendChild(d);
            // Append li as the last child of ul with id = "list"
        }
    }
    
}