
function formValidation () {

var user = document.forms[regForm][userName]
var pass = document.forms[regForm][password]
var full = document.forms[regForm][fullName]
var email = document.forms[regForm][email]
var age = document.forms[regForm][age]

if (user.value == "") {
    window.alert("Please enter your name!");
    return false;
}

if (password.value == "")                       
    {
        window.alert("Please enter your password");
        password.focus();
        return false;
    }

if (email.value == "") {
    window.alert("Please enter a valid e-mail address.");
    email.focus();
    return false;
}

if (email.value.indexOf("@", 0) < 0) {
    window.alert("Please enter a valid e-mail address.");
    email.focus();
    return false;
}

if (email.value.indexOf(".", 0) < 0) {
    window.alert("Please enter a valid e-mail address.");
    email.focus();
    return false;
}

return true;
}
