window.onload = function () {
    document.getElementById("loginBtn").addEventListener("click", userLogin);
}

function userLogin(){
    let user =  document.getElementById("user");
    let pass = document.getElementById("pass");

     loginInfo = [user.value, pass.value];
}