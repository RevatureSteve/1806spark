window.onload = function() {


var psw = document.getElementById("pass");
var re_psw = document.getElementById("repass");
var length = document.getElementById("length");
var capital = document.getElementById("capital");
var lowercase = document.getElementById("lowercase");
var number = document.getElementById("number");



// when the user clicks on the password field, show the message box
psw.onfocus = function(){
    document.getElementById("requirement_box").style.display
    = "block";
}
// box hides when user clicks outside the box
psw.onblur = function() {
    document.getElementById("requirement_box").style.display
     = "none";
}
// When the user starts to type something inside
psw.onkeyup = function(){
// validate length
    if(psw.value.length >= 8){
        length.classList.remove("invalid");
        length.classList.add("valid");
       // length.classList.add("image_check");

    } else {
        length.classList.remove("valid");
        //length.classList.remove("image_check");
        length.classList.add("invalid");
    }
// validate capital letter
    var upperCaseLetter = /[A-Z]/g;
    if(psw.value.match(upperCaseLetter)){
        capital.classList.remove("invalid");
        capital.classList.add("valid");
    } else{
        capital.classList.remove("valid");
        capital.classList.add("invalid");
    }
// validate lowercase letter
    var lowerCaseLetter = /[a-z]/g;
    if(psw.value.match(lowerCaseLetter)){
        lowercase.classList.remove("invalid");
        lowercase.classList.add("valid");
    } else{
        lowercase.classList.remove("valid");
        lowercase.classList.add("invalid");
    }
// validate numbers
    var numbers = /^(?=.*[0-9_\W]).+$/g;
    if(psw.value.match(numbers)){
        number.classList.remove("invalid");
        number.classList.add("valid");
    } else{
        number.classList.remove("valid");
        number.classList.add("invalid");
    }
}

// when the user clicks on the re-password field, show the message box
re_psw.onfocus = function(){
    document.getElementById("check_box").style.display
    = "block";
}
// box hides when user clicks outside the box
re_psw.onblur = function() {
    document.getElementById("check_box").style.display
     = "none";
}
// When the user starts to type something inside
re_psw.onkeyup = function(){
// validate password
    if(re_psw.value == psw.value){
        confirmation.classList.remove("invalid");
        confirmation.classList.add("valid");

    } else {
        confirmation.classList.remove("valid");
        confirmation.classList.add("invalid");
    }
}

}

