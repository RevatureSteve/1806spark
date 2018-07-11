
window.onload = function () {
    let password = document.getElementById('password');
    document.getElementById("register_button").addEventListener("click", passwordMatch);
    password.addEventListener('input', validPassword);
    password.addEventListener('focusin', showPopup);
    password.addEventListener('focusout', showPopup);
}



function passwordMatch() {
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    if (password === confirmPassword) {

    } else {
        alert("Passwords must match");
    }
}

// Checks password meets requirements 
function validPassword() {
    let check = document.getElementsByClassName('check');
    for (let i = 0; i < check.length; i++) {
        check[i].style.visibility = "hidden";
    }
    let input = password.value;
    if (input.length >= 8) {
        check[0].style.visibility = "visible";
    };
    for (let i = 0; i < input.length; i++) {
        let char = input.charAt(i);
        if (isNaN(char)) {
            if (char === input.charAt(i).toUpperCase()) {
                check[1].style.visibility = "visible";
            };
            if (char === input.charAt(i).toLowerCase()) {
                check[2].style.visibility = "visible";
            };
            if (isSpecial(char)){
                check[4].style.visibility = "visible";
            }
        } else if (!isNaN(char)) {
            check[3].style.visibility = "visible";
        };
    }
}

/*
    Looks to see if special character
    Takes in one character
    returns true if special character, false otherwise
*/
function isSpecial(char){
    let special = "~!@#$%^&*+=";
    for (let i = 0; i < special.length; i++){
        if (special.charAt(i) == char){
            return true;
        };
    };
    return false;
}

// Shows password popup
function showPopup() {
    let check = document.getElementsByClassName('check');
    for (let i = 0; i < check.length; i++) {
        check[i].style.visibility = "hidden";
    }
    validPassword();
    let popup = document.getElementById('passwordPopup');
    if (popup.style.display == "none" || popup.style.display == "") {
        popup.style.display = "inline";
    } else {
        popup.style.display = "none";
    }

}