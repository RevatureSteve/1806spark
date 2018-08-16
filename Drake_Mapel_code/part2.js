// display from n1 to n2, smaller to larger

document.getElementById("sbt").addEventListener("click", fb2);

function lnk(text) {
    var li = document.createElement("LI");
    var t = document.createTextNode(text);
    li.appendChild(t);
    document.getElementById("fizzbuzz").appendChild(li);
}

function fb2() {
    var nput = document.getElementById("inpt").value;
    var nput2 = document.getElementById("inpt2").value;
    if ( nput != "" && nput2 != "" ) {
        for ( var i = parseInt(nput); i <= nput2; i++ ) {
            if ( i % 15 == 0 ) { lnk("FizzBuzz"); }
            else if ( i % 3 == 0 ) { lnk("Fizz"); }
            else if ( i % 5 == 0 ) { lnk("Buzz"); }
            else lnk( i );
        }
    } else alert("fill out both number fields");
}