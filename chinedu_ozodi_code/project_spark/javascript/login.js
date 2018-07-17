var username;
var password;

window.onload = () => {
    document.getElementById('loginSignIn').addEventListener('mousedown', login);
    username = document.getElementById('loginUsername');
    password = document.getElementById('loginPassword');

    //Reset cookies
    setCookie('username', '',1);
    setCookie('password', '',1);
}

function login(){
    console.log('logging in...');
    setCookie('username',username.value,1);
    setCookie('password', password.value,1);
    // redirect
    window.location = 'http://localhost:3000/pages/main.html';
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}