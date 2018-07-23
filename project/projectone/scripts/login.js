var userName;
var UserPassword;


document.querySelector("#signedUp").addEventListener("click", userInlogin);
//document.querySelector("#makeClick").addEventListener("mouseover", userInlogin);

 function userInlogin() {
    userName = document.querySelector("#userEmail").value;
    UserPassword = document.querySelector("#password").value;
    document.querySelector("h1").innerHTML = "Welcome Back Dear User" + userName;
    console.log(userName);
    //alert(userName);
    alertMe()
    //return userName, UserPassword;
    
}

function alertMe() {
if (userName !== null && UserPassword !== null) {
    alert("Welcome back: " + userName)
  
} else if (userName == null) {
    alert('Please type your name')
}
//location.reload(false);
}