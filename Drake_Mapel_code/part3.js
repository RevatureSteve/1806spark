// display from n1 to n2

document.getElementById("sbt").addEventListener("click", fb3);

function lnk(text) {
    var li = document.createElement("LI");
    var t = document.createTextNode(text);
    li.appendChild(t);
    document.getElementById("fizzbuzz").appendChild(li);
}

function fb3() {
    var nput = document.getElementById("inpt").value;
    var nput2 = document.getElementById("inpt2").value;
    nput = parseInt(nput);
    nput2 = parseInt(nput2);
    if ( nput != undefined && nput2 != undefined ) {
        if ( nput > nput2 ) {
            nput = -nput;
            nput2 = -nput2;
            var flip = true;
        }
        for ( var i = nput; i <= nput2; i++ ) {
            if ( i % 15 == 0 ) { lnk("FizzBuzz"); }
            else if ( i % 3 == 0 ) { lnk("Fizz"); }
            else if ( i % 5 == 0 ) { lnk("Buzz"); }
            else if ( flip == true ) { lnk( -i ); }
            else lnk( i );
        }
    } else alert("fill out both number fields")
}