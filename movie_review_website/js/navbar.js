let home;
let personal;
let account;
var loggedIn = false;
var accountLogged = {
    name: "Marcin Salamon",
    email: "salamonmarcin29@gmail.com"
}

window.onload = function() {
    document.getElementById("home").onclick = changeIFrame;
    document.getElementById("personal").onclick = changeIFrame;
    document.getElementById("account").onclick = changeIFrame;
    document.getElementById("login").onclick = changeIFrame;
}

function changeIFrame(){
    document.getElementsByTagName("iframe")[0].src = this.id + ".html";
}

