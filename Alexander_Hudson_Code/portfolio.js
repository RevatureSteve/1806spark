window.onload = function(){}

var typed= false; // 


window.onload=function(){
    if (document.getElementById("load") &&typed==false){ // if it could find this in the document than it is true,
        typeWriter();
    }
}
var i = 0;
var txt = 'S.L Productions'; /* The text */
var speed = 20; /* The speed/duration of the effect in milliseconds */

function typeWriter() {
  if (i < txt.length) {
    document.getElementById("demo").innerHTML += txt.charAt(i);
    i++;
    setTimeout(typeWriter, speed); 
    typed=true; // changing typed back to true so that it doesnt run the function doesnt run again.
  }
}

// Register

var myInput = document.getElementById("psw");
var letter =document.getElementById("special");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
  document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) { 
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
}
