var typed = false; // 
let caps;

window.onload = function () {
  if (document.getElementById("load") && typed == false) { // if it could find this in the document than it is true,
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
    typed = true; // changing typed back to true so that it doesnt run the function again.
  }
}


// Register

var myInput = document.getElementById("psw");
var myInput2 = document.getElementById("psw2");
var letter = document.getElementById("special");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");


// Pop Up
// When the user clicks on the password field, show the message box
myInput.addEventListener("focusin", function () {
  document.getElementById("message").style.display = "block";
})

// When the user clicks outside of the password field, hide the message box
myInput.addEventListener("focusout", function () {
  document.getElementById("message").style.display = "none";
})

                                                                                                              // Register validation 

// Mininmum Length

myInput.addEventListener('input', valid);
function valid(){
  let type = myInput.value;
  if (type.length >= 8) {
    length.style.color = "green";
  } else {
    length.style.color = "red";
  }
}

// Capital Letters

  myInput.addEventListener('input', cap);
  function cap(){
    let regex = /^(?=.*[A-Z]).+$/;
    caps = event.target.value
    console.log(caps);
    if(regex.test(caps)){
      document.getElementById("capital").style.color = "green"; 
    }
    else{
      document.getElementById("capital").style.color = "red";
    }
  }

// Numbers
  
  myInput.addEventListener('input', num);
  function num(){
    let regex = /^(?=.*[0-9]).+$/;
    caps = event.target.value
    console.log(caps);
    if(regex.test(caps)){
      document.getElementById("number").style.color = "green"; 
    }
    else{
      document.getElementById("number").style.color = "red";
    }
  }
  
// Special Characters

  myInput.addEventListener('input', spe);
  function spe(){
    let regex = /^(?=.*[_\W]).+$/;
    caps = event.target.value
    console.log(caps);
    if(regex.test(caps)){
      document.getElementById("special").style.color = "green"; 
    }
    else{
      document.getElementById("special").style.color = "red";
    }
  }




  
    



