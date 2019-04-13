let caps;
var pw = document.getElementById('pw');
var confirm = document.getElementById('confirm');
var letter = document.getElementById('special');
var capital = document.getElementById('capital');
var number = document.getElementById('number');
var length = document.getElementById('length');

 
    pw.addEventListener('input', valid); 
    function valid () {
        let type = pw.value; 
        if( type.length >= 6 ) {
            length.style.color = "green";
        } else {
            length.style.color = "red";
        }
    }
    
    pw.addEventListener('input', cap); 
    function cap () {
        let regex = /^(?=.*[A-Z]).+$/;
        caps = event.target.value
        console.log(caps); 
        if(regex.test(caps)) {
            document.getElementById("capital").style.color = "green";
        } else {
            document.getElementById("capital").style.color = "red";
        }
    }
    pw.addEventListener('input', num); 
    function num () {
        let regex = /^(?=.*[0-9]).+$/;
        caps = event.target.value
        console.log(caps); 
        if(regex.test(caps)) {
            document.getElementById("number").style.color = "green";
        } else {
            document.getElementById("number").style.color = "red";
        }
    }
    pw.addEventListener('input', num); 
    function num () {
        let regex = /^(?=.*[0-9]).+$/;
        caps = event.target.value
        console.log(caps); 
        if(regex.test(caps)) {
            document.getElementById("number").style.color = "green";
        } else {
            document.getElementById("number").style.color = "red";
        }
    }
    pw.addEventListener('input', spe); 
    function spe () {
        let regex = /^(?=.*[_\W]).+$/;
        caps = event.target.value
        console.log(caps); 
        if(regex.test(caps)) {
            document.getElementById("special").style.color = "green";
        } else {
            document.getElementById("special").style.color = "red";
        }
    }


