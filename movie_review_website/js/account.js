var accountLogged = {
    name: "Marcin Salamon",
    email: "salamonmarcin29@gmail.com"
}

window.onload = function(){
    document.getElementById("name").innerHTML = accountLogged.name;
    document.getElementById("email").innerHTML = accountLogged.email
}