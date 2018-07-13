// Validates registration information before submitting to server
// window.onload being used by app.js
// var app = require('app');
// Global variables

let requiredChars = ["!", "@", "#", "$", "%", "^", "&", "*"];
let requiredDigits = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

// Elements to modify
let registerPassword = document.getElementById("registerPassword");
let verifyPassword = document.getElementById("confirmPassword");

// Set initial input settings
verifyPassword.style.display = "none";
registerPassword.style.marginBottom = "15px";
registerPassword.style.borderBottomLeftRadius = "1mm";
registerPassword.style.borderBottomRightRadius = "1mm";

// Set Listeners

registerPassword.addEventListener("input", () => passwordChanged(registerPassword, verifyPassword));
verifyPassword.addEventListener("input", () => passwordVerify(registerPassword, verifyPassword));

// checks for correct password parameters in a changed password element
function passwordChanged(node, verify) {
    var hasChar = false;
    var hasDigit = false;
    var hasMin = false;

    // Get checkboxes
    var checkboxMin = document.getElementById("checkboxMin");
    var checkboxChar = document.getElementById("checkboxChar");
    var checkboxNum = document.getElementById("checkboxNum");

    // Set initial conditions
    node.style.backgroundColor = "#ff867c";
    checkboxChar.checked = false;
    checkboxMin.checked = false;
    checkboxNum.checked = false;
    verify.style.display = "none";
    node.style.marginBottom = "15px";
    node.style.borderBottomLeftRadius = "1mm";
    node.style.borderBottomRightRadius = "1mm";

    // Search to find if required settings are met
    if (node.value.length >= 5) {
        hasMin = true;
        checkboxMin.checked = true;
    }

    for (let i = 0; i < requiredChars.length; i++) {
        if (node.value.indexOf(requiredChars[i]) >= 0) {
            hasChar = true;
            checkboxChar.checked = true;
            break;
        }
    }
    for (let i = 0; i < requiredDigits.length; i++) {
        if (node.value.indexOf(requiredDigits[i]) >= 0) {
            hasDigit = true;
            checkboxNum.checked = true;
            break;
        }
    }

    if (hasChar && hasDigit && hasMin) {
        node.style.backgroundColor = "#80e27e";
        verify.style.display = "inline-block";
        node.style.marginBottom = "-1px";
        node.style.borderBottomLeftRadius = "0mm";
        node.style.borderBottomRightRadius = "0mm";
    }
}

function passwordVerify(initialPw, verifyPw) {
    if (initialPw.value != verifyPw.value) {
        verifyPw.style.backgroundColor = "#ff867c";
        changeToRed();
    }
    else {
        verifyPw.style.backgroundColor = "#80e27e";
        changeToGreen();
    }
}