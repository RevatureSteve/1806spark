let home;
let personal;
let account;
var loggedIn = true;
var accountLogged = {
    name: "Marcin Salamon",
    email: "salamonmarcin29@gmail.com"
}

window.onload = function() {
    home = document.getElementById("home").onclick = changeIFrame;
    personal = document.getElementById("personal").onclick = changeIFrame;
    account = document.getElementById("account").onclick = changeIFrame;
    if (loggedIn) {
        document.getElementById("login").innerHTML = accountLogged.name;
    }
}

function changeIFrame(){
    document.getElementsByTagName("iframe")[0].src = this.id + ".html";
}

