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
    document.getElementById("new-review").onclick = changeIFrame;
    document.getElementById("account").onclick = changeIFrame;
    document.getElementById("register").onclick = changeIFrame;
    document.getElementById("login").onclick = changeIFrame;
    document.getElementById('register').innerHTML = accountLogged.name;
}

function changeIFrame(){
    document.getElementsByTagName("iframe")[0].src ='pages/' + this.id + ".html";
    document.getElementById('register').innerHTML = accountLogged.name;
}



