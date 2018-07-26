window.onload = function () {
    document.getElementById("userConfirm").addEventListener("keydown", register);

}

function register1() {


    if (document.getElementById("username").value.length > 2) 
    {
        document.getElementById("userConfirm").style.color = "green";

    } else {
        document.getElementById("userConfirm").style.color = "red";

    }
}
function register2() {


    if (document.getElementById("password").value.length > 5)  
    {
        document.getElementById("pwConfirm").style.color = "green";

    } else {
        document.getElementById("pwConfirm").style.color = "red";

    }
}

function register3() {
    if (document.getElementById("confirm").value == document.getElementById("password").value) 
    {
        document.getElementById("cfConfirm").style.color = "green";

    } else {
        document.getElementById("cfConfirm").style.color = "red";

    }
}
