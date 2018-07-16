document.getElementById("login").addEventListener("click", login);

// function login() {
//     window.open("/home", "_self");
// }

function login() {
    var a = document.forms["login"]["username"].value;
    var b = document.forms["login"]["password"].value;
    if (a == "" || b == "") {
        alert("Name must be filled out");
    } else {
        window.open("/home", "_self");
    }
}