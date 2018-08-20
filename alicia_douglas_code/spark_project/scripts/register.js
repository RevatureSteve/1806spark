
let passVal = [false, false, false, false, false];

let userUrl = 'http://localhost:3001/user';

window.onload = function () {
    let password = document.getElementById('password');
    let passConf = document.getElementById('confirmPassword');
    document.getElementById("register_button").addEventListener("click", regAuth);
    password.addEventListener('input', validPassword);
    password.addEventListener('focusin', showPopup);
    password.addEventListener('focusout', showPopup);
    passConf.addEventListener('input', passCheck);
    passConf.addEventListener('focusin', showConfPopup);
    passConf.addEventListener('focusout', showConfPopup);

    // document.getElementById('registerForm').addEventListener('submit', regAuth);
}


function regAuth() {
    let special = " !\"#$%&'()*+,-./:;<=>?@[\]^_`{|}~";
    // Checks password for requirements
    for (let i = 0; i < passVal.length; i++) {
        if (!passVal[i]) {
            return alert('Passwords must have: \nA length of 8 characters \nOne capital letter \nOne lowercase letter \nOne number \nOne special character: ' + special)
        }
    }
    // Checks to see if passwords match
    if (!passwordMatch()) {
        return alert('Passwords must match');
    }
    if (userNameValidate()){
        return alert("Username is already taken");
    }
    addUser();
}



function addUser() {
    let name = document.getElementById('name').value;
    let email = document.getElementById('emailAddress').value;
    let dob = document.getElementById('dob').value;
    let user = document.getElementById('userName').value;
    let password = document.getElementById('password').value;
    let userData = {
        "name": name,
        "emailAddress": email,
        "dob": dob,
        "userName": user,
        "password": password
    };

    fetch(userUrl, {
        method: 'POST',
        body: JSON.stringify(userData),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(userData => userData.json()).then(u => {
        console.log(u);
        alert('registration successful');
    });
}




function passwordMatch() {
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    if (password === confirmPassword) {
        return true;
    } else {
        return false;
    }
}

// Checks password meets requirements 
function validPassword() {
    let check = document.getElementsByClassName('check');
    for (let i = 0; i < check.length-1; i++) {
        check[i].style.visibility = "hidden";
        passVal[i] = false;
    }
    let input = password.value;
    if (input.length >= 8) {
        check[0].style.visibility = "visible";
        passVal[0] = true;
    };
    for (let i = 0; i < input.length; i++) {
        let char = input.charAt(i);
        if (isNaN(char)) {
            if (isSpecial(char)) {
                check[4].style.visibility = "visible";
                passVal[4] = true;
            } else if (char === input.charAt(i).toUpperCase()) {
                check[1].style.visibility = "visible";
                passVal[1] = true;
            } else if (char === input.charAt(i).toLowerCase()) {
                check[2].style.visibility = "visible";
                passVal[2] = true
            };

        } else if (!isNaN(char)) {
            check[3].style.visibility = "visible";
            passVal[3] = true;
        };
    }
}

/*
    Looks to see if special character
    Takes in one character
    returns true if special character, false otherwise
*/
function isSpecial(char) {
    let special = " !\"#$%&'()*+,-./:;<=>?@[\]^_`{|}~";
    for (let i = 0; i < special.length; i++) {
        if (special.charAt(i) == char) {
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

// Shows Confirm Password Popup
function showConfPopup() {
    // let check = document.getElementsByClassName('check')[5];
    passCheck();
    let popup = document.getElementById('ConfirmPasswordPopup');
    if (popup.style.display == "none" || popup.style.display == "") {
        popup.style.display = "inline";
    } else {
        popup.style.display = "none";
    }
}

function passCheck() {
    let check = document.getElementsByClassName('check')[5];
    if (passwordMatch()) {
        check.style.visibility = "visible";
    } else {
        check.style.visibility = "hidden";
    }
}


var users = null;
callUsers();

function callUsers() {
    fetch(userUrl).then((resp) => {
        return resp.json();
    }).then((data) => {
        console.log(data);
        users = data;
    })
}

// Checks to see if userName is already being used
function userNameValidate(){
    let userName = document.getElementById('userName').value;
    for(let i = 0; i < users.length; i++){
        if (userName == users[i].userName){
            return true;
        }
    }
    return false;
}