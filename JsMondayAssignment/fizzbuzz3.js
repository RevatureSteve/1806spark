/* Part 3 Allow either box to be larger or smaller number
make a separate js file for each please
*/

function fizzbuzz(){
    var res = document.getElementById("fizzbuzzinput").value;
    var res2 = document.getElementById("fizzbuzzinput2").value;
    for (var i = res; i <= res2; i++) {
        if( res > res2){
            var temp= res;
            res = res2;
            res2 = temp;
        }
        else if (i % 3 == 0 && i % 5 != 0 ) {
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