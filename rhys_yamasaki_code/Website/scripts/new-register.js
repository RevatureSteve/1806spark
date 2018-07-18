let url = "http://localhost:3000/register";
document.getElementById("signup").addEventListener('click', newUser);


function newUser() {
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById('lastName').value;
    let username = document.getElementById('username').value;
    let email = document.getElementById('emailInput').value;
    let password = document.getElementById('password').value;

    let data = {
        "firstName": firstName,
        "lastName": lastName,
        "username": username,
        "emailAddress": email,
        "password": password
    }

    fetch(url, {
        method: 'POST',  // to post data to the db
        body: JSON.stringify(data),
        headers:{
            'Content-Type': 'application/json'
        }
    }).then(data => data.json()).then(u => {
        console.log(u);
        window.location.href = "./profile.html"
    })
}


// Validation for password
document.getElementById("password").addEventListener("input", passwordValidation);
document.getElementById("password").addEventListener("focus", passwordPopupCheck);
document.getElementById("password").addEventListener("blur", toggleCheck);

function passwordPopupCheck() {
    var popup = document.getElementById("myPopup");
    popup.classList.toggle("show");
    passwordValidation();
}

function toggleCheck() {
    var checkmarks = document.getElementsByClassName("checkmark");
    var popup = document.getElementById("myPopup");
    if (popup.classList.contains("show")) {
        for (let i = 0; i < checkmarks.length; i++) {
            checkmarks[i].classList.remove("show");
        }
    }
    popup.classList.toggle("show");
}

function passwordValidation() {
    let value = document.getElementById("password").value;
    let visibility = document.getElementById("myPopup");
    let length = value.length;
    let checkUpper = /[A-Z]/.test(value);
    let checkLower = /[a-z]/.test(value);
    let checkSpecial = /[!?@#$&*.]/.test(value);
    let checkNum = /\d/.test(value);
    let checked;
    console.log("check for length: " + length);
    if (length > 7 && length < 21) {
        console.log("You have a good length of: " + length);
        checked = document.getElementsByClassName("checkmark")[0];
        checked.classList.add("show");
    } else {
        checked = document.getElementsByClassName("checkmark")[0];
        checked.classList.remove("show");
    }
    if (checkUpper) {
        console.log("check for uppercase: " + checkUpper);
        checked = document.getElementsByClassName("checkmark")[1];
        checked.classList.add("show");
    } else {
        checked = document.getElementsByClassName("checkmark")[1];
        checked.classList.remove("show");
    }

    if (checkLower) {
        console.log("check for lowercase: " + checkLower);
        checked = document.getElementsByClassName("checkmark")[2];
        checked.classList.add("show");
    } else {
        checked = document.getElementsByClassName("checkmark")[2];
        checked.classList.remove("show");
    }
    if (checkNum) {
        console.log("check for number: " + checkNum);
        checked = document.getElementsByClassName("checkmark")[3];
        checked.classList.add("show");
    } else {
        checked = document.getElementsByClassName("checkmark")[3];
        checked.classList.remove("show");
    }
    if (checkSpecial) {
        console.log("check for special character: " + checkSpecial);
        checked = document.getElementsByClassName("checkmark")[4];
        checked.classList.add("show");
    } else {
        checked = document.getElementsByClassName("checkmark")[4];
        checked.classList.remove("show");
    }
    if (checkLower && checkUpper && checkSpecial && checkNum && length > 7 && length < 21) {
        document.getElementById("password").classList.remove("is-invalid");
        document.getElementById("password").classList.add("is-valid");
        // document.getElementById("signup").classList.toggle("disabled");
        // document.getElementById("signup").removeAttribute("disabled");
    }
    else {
        document.getElementById("password").classList.remove("is-valid");
        document.getElementById("password").classList.add("is-invalid");
        // document.getElementById("signup").classList.toggle("disabled");
        // document.getElementById("signup").setAttribute("disabled");
    }
}
document.getElementById("passwordCheck").addEventListener("input", matchPassword);

function matchPassword() {
    let passwordInput = document.getElementById("password").value;
    let compareValue = document.getElementById("passwordCheck").value;
    let checkPassword = document.getElementById("passwordCheck");
    if (passwordInput === compareValue) {
        checkPassword.classList.remove("is-invalid");
        checkPassword.classList.add("is-valid");
        console.log("passwords match");
    }
    else {
        checkPassword.classList.remove("is-valid");
        checkPassword.classList.add("is-invalid");
        console.log("passwords don't match");
    }
}

function noNumbers() {
    let firtName = document.getElementById("firstName").value;
}




