document.getElementById("register_button").addEventListener("click", passwordMatch);

function passwordMatch(){
    var password = document.getElementsByName("password")[0].value;
    var confirmPassword = document.getElementsByName("confirmPassword")[0].value;
    if (password === confirmPassword){
       
    } else {
        alert("Passwords must match");
    }
}