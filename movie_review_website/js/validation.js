let passed = 'data:image/png;base64,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';
let failed = 'https://vignette.wikia.nocookie.net/mysingingmonsters/images/2/24/Red-x.png/revision/latest?cb=20171113115328'
window.addEventListener("load", () => {
    document.getElementById('username').onkeyup = validation;
    document.getElementById('pwd1').onkeyup = validation;
    document.getElementById('pwd2').onkeyup = validation;
})

function validation() {
    let username = document.getElementById('username');
    let pwd1 = document.getElementById('pwd1');
    let pwd2 = document.getElementById('pwd2');

    if (validUsername(username.value)) {
        document.getElementById('usernameImg').src = passed;
    } else {
        document.getElementById('usernameImg').src = failed;
    }

    if (checkCap(pwd1.value)) {
        document.getElementById('oneCap').src = passed;
    } else {
        document.getElementById('oneCap').src = failed;
    }

    if(checkSpecialChar(pwd1.value)){
        document.getElementById('specialChar').src = passed;
    } else {
        document.getElementById('specialChar').src = failed;
    }

    if (checkLength(pwd1.value)) {
        document.getElementById('minLengthImg').src = passed;
    } else {
        document.getElementById('minLengthImg').src = failed;
    }

    if (comparePasswords(pwd1.value, pwd2.value)) {
        document.getElementById('compare').src = passed;
    } else {
        document.getElementById('compare').src = failed;
    }
}

function checkCap(pwd1) {
    for (let i = 0; i < pwd1.length; i++) {
        let character = pwd1.charAt(i);
        if (isNaN(character * 1) && character == character.toUpperCase()) {
            return true;
        }

    }
    return false;
}

function checkLength(pwd1){
    if(pwd1.length>8){
        return true;
    }
    return false;
}

function checkSpecialChar(pwd1){
    for (let i = 0; i < pwd1.length; i++) {
        let character = pwd1.charAt(i);
        if (character == '&' || character == '.' || character == '!' || character == '@') {
            return true;
        }
    }
    return false;
}

function comparePasswords(pwd1, pwd2) {
    if (!pwd1 || !pwd2) {
        return false;
    }
    if (pwd1 == pwd2) {
        return true;
    }
    return false;
}

function validUsername(username) {
    if (username != 0 && 2 < username.length && username.length < 11) {
        return true;
    }

    return false;
}



