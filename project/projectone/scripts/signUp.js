
document.querySelector("#signedUp").addEventListener("click", matchIsMatch);



function matchIsMatch() {

    var userPassword = document.querySelector("#password").value;
    var tempPassword = document.querySelector("#repassword").value;
    if (userPassword.lenght === tempPassword) {
       console.log("a new sign");
       document.querySelector("h1").innerHTML = " Welcome To Tavel Reviews,<br> Please wait for server to refresh:";

    } else { alert("The password do not match"); }
    //alert(tempPassword, UserPassword);

    return userPassword, tempPassword;
}

// never invoked
function changeHeading() {
    if (userName == tempPassword) {
        let thankYou = document.querySelector("h1").innerHTML = " Welcome To Tavel Reviews,<br> now you are able to:";
    }
}

//location.reload(false);