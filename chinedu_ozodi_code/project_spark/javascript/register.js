// Validates registration information before submitting to server

// Global variables

let requiredChars = ["!", "@", "#", "$", "%", "^", "&", "*"];
let requiredDigits = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

window.onload = () => {
    // Set Listeners
    let registerPassword = document.getElementById("registerPassword");
    let verifyPassword = document.getElementById("confirmPassword");
    registerPassword.addEventListener("input", () => passwordChanged(registerPassword));
    verifyPassword.addEventListener("input", () => passwordVerify(registerPassword, verifyPassword));
}

// checks for correct password parameters in a changed password element
function passwordChanged(node) {
    if (node.value.length < 5) {
        node.style.backgroundColor = "#ff867c";
    }
    else {
        var hasChar = false;
        var hasDigit = false;
        node.style.backgroundColor = "#ff867c";
        for (let i = 0; i < requiredChars.length; i++) {
            if (node.value.indexOf(requiredChars[i]) >= 0) {
                hasChar = true;
                break;
            }
        }
        for (let i = 0; i < requiredDigits.length; i++) {
            if (node.value.indexOf(requiredDigits[i]) >= 0){
                hasDigit = true;
                break;
            }
        }
    }
    if (hasChar && hasDigit) {
        node.style.backgroundColor = "#80e27e";
    }
}

function passwordVerify(initialPw, verifyPw) {
    if (initialPw.value != verifyPw.value) {
        verifyPw.style.backgroundColor = "#ff867c";
    }
    else {
        verifyPw.style.backgroundColor = "#80e27e";
    }
}