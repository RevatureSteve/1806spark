// contains the main functions for the website
var profile;
var username = null;
window.onload = () => {
    profile = document.getElementById('profileName');
    login();
}

// Login user with cookies
function login() {
    username = getCookie('username');
    if (!username){
        window.location = 'http://localhost:3000/';
    }else if (profile) {
        profile.innerHTML = username;
    }
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

// Changes page color theme to green
var changeToGreen = function () {
    changeClasses("color-main", "color-green");
    changeClasses("color-main-dark", 'color-green-dark');
    changeClasses("color-main-light", 'color-green-light');
    changeClasses("color-red", 'color-green');
    changeClasses("color-red-dark", 'color-green-dark');
    changeClasses("color-red-light", 'color-green-light');
}

var changeToRed = function () {
    changeClasses("color-main", "color-red");
    changeClasses("color-main-dark", 'color-red-dark');
    changeClasses("color-main-light", 'color-red-light');
    changeClasses("color-green", 'color-red');
    changeClasses("color-green-dark", 'color-red-dark');
    changeClasses("color-green-light", 'color-red-light');
}

// Changes all elements with initClass to endClass
var changeClasses = function (initClass, endClass) {
    let initClassList = document.getElementsByClassName(initClass);
    for (let i = initClassList.length - 1; i >= 0; i--) {
        let node = initClassList[i];
        node.classList.remove(initClass);
        node.classList.add(endClass);
    }
}