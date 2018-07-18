var username;
var password;

window.onload = () => {
    document.getElementById('loginSignIn').addEventListener('mousedown', login);
    username = document.getElementById('loginUsername');
    password = document.getElementById('loginPassword');

    //Reset cookies
    setCookie('username', '',1);
    setCookie('password', '',1);
}

function login(){
    console.log('logging in...');

    fetch('/user/login', {
        method: "POST", // *GET, POST, PUT, DELETE, etc.
        headers: {
            "Content-Type": "application/json; charset=utf-8",
            "Accept": "application/json"
        },
        body: JSON.stringify({ username: username.value, password: password.value }), // body data type must match "Content-Type" header
    }).then(response => {
        return response.json();
    }).then(myJson => {

        if (myJson.length > 0){
            setCookie('username',username.value,1);
            setCookie('password', password.value,1);
            
            // redirect
            window.location = 'http://localhost:3000/pages/main.html';
        }
        else{
            alert("Incorrect username or password");
        }
    })

}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}