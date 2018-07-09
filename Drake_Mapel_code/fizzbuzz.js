// make a version where one condition trips into the next?  3 then 5 gives combined case
var nput = document.getElementById("inpt").value;

// document.getElementById("sbt").addEventListener("click", fb);

function lnk(text) {
    var li = document.createElement("LI");
    var t = document.createTextNode(text);
    li.appendChild(t);
    document.getElementById("fizzbuzz").appendChild(li);
}

function fb() {
    for ( var i = 1; i <= nput; i++ ) {
        if ( i % 15 == 0 ) { lnk("FizzBuzz"); }
        else if ( i % 3 == 0 ) { lnk("Fizz"); }
        else if ( i % 5 == 0 ) { lnk("Buzz"); }
        else lnk( i );
    }
}