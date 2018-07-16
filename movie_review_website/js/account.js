window.onload = function(){
    document.getElementById("name").innerHTML = parent.accountLogged.name;
    document.getElementById("email").innerHTML = parent.accountLogged.email;
}