/* Create a 2nd input box
Instead of 0, use both the input boxes to display N to N with requirements of Part 1
*/


function fizzbuzz(){
    var res = document.getElementById("fizzbuzzinput").value;
    var res2 = document.getElementById("fizzbuzzinput2").value;
    for (var i = res; i <= res2; i++) {
        if (i % 3 == 0 && i % 5 != 0) {
            var num = document.createElement("li");
            var x = document.createTextNode("Fizz");
            num.appendChild(x);
            document.getElementById("fizzbuzzoutput").appendChild(num);
        } else if (i % 3 != 0 && i % 5 == 0) {
            var num = document.createElement("li");
            var x = document.createTextNode("Buzz");
            num.appendChild(x);
            document.getElementById("fizzbuzzoutput").appendChild(num);  
        } else if (i % 3 == 0 && i % 5 == 0) {
            var num = document.createElement("li");
            var x = document.createTextNode("FizzBuzz");
            num.appendChild(x);
            document.getElementById("fizzbuzzoutput").appendChild(num);
        } else {
            var num = document.createElement("li");
            var x = document.createTextNode(i);
            num.appendChild(x);
            document.getElementById("fizzbuzzoutput").appendChild(num);
            
        }
    }  
}   