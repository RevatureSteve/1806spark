




// document.getElementById('success-btn').addEventListener('click', passwordComp);


// function passwordComp () {

//   let conf = document.getElementById("confirm").value;
//   let conf = document.getElementById("confirm").value;
  
// }

// let income = document.getElementById('income').value;
// let amount = document.getElementById('budgetInput2').value;

function checkPass()
{
    //Store the password field objects into variables ...
    var psw = document.getElementById('psw');
    var confirm = document.getElementById('confirm');
    //Store the Confimation Message Object ...
    var message = document.getElementById('confirmMessage');
    //Set the colors we will be using ...
    var good = "#66cc66";
    var bad = "#ff6666";
    //Compare the values in the password field 
    //and the confirmation field
    if(psw.value == confirm.value){
        //The passwords match. 
        //Set the color to the good color and inform
        //the user that they have entered the correct password 
        confirm.style.backgroundColor = good;
        message.style.color = good;
        message.innerHTML = "Passwords Match!"
    }else{
        //The passwords do not match.
        //Set the color to the bad color and
        //notify the user.
        confirm.style.backgroundColor = bad;
        message.style.color = bad;
        message.innerHTML = "Passwords Do Not Match!"
    }
}  


var myInput = document.getElementById("psw");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");
var special = document.getElementById("special")

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
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
  
  //validate special
  var specialChar = /[!@#$%^*]/g;
  if(myInput.value.match(specialChar)) {
    special.classList.remove("invalid");
    special.classList.add("valid");
  } else {
    special.classList.remove("valid");
    special.classList.add("invalid");
  }

//   <!-- (?=.*[!@#$%^&*]) - Assert a string has at least one special character. -->

}